package org.algos.AdvancedAndRare.MinimumCostMaxFlowAlgo;

//          Min Cost Max Flow (MCMF) is a network flow algorithm that
//          sends the maximum possible flow from source to sink while
//          minimizing total cost of transporting that flow.
//          Each edge has capacity and cost per unit flow.


//            Algorithm Explanation
//
//             We repeat:
//
//              Use Shortest Path (Bellman-Ford/SPFA) on residual graph to
//              find the minimum cost path from source to sink.
//
//              Send the maximum possible flow through that path.
//
//              Update residual capacities.
//
//              Repeat until no path exists.
//
//              Greedy on shortest cost path + residual capacity maintenance.

import java.io.*;
import java.util.*;

class MinCostMaxFlow {

    static class Edge {
        int to;
        int rev;
        int capacity;
        int cost;

        Edge(int to, int rev, int capacity, int cost) {
            this.to = to;
            this.rev = rev;
            this.capacity = capacity;
            this.cost = cost;
        }
    }

    static class MCMF {
        int n;
        List<Edge>[] graph;

        MCMF(int n) {
            this.n = n;
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
        }

        void addEdge(int u, int v, int capacity, int cost) {
            graph[u].add(new Edge(v, graph[v].size(), capacity, cost));
            graph[v].add(new Edge(u, graph[u].size() - 1, 0, -cost));
        }

        int[] minCostMaxFlow(int source, int sink) {
            int flow = 0;
            int cost = 0;

            int[] dist = new int[n];
            int[] parentNode = new int[n];
            int[] parentEdge = new int[n];

            while (true) {
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[source] = 0;

                boolean[] inQueue = new boolean[n];
                Queue<Integer> queue = new LinkedList<>();
                queue.add(source);
                inQueue[source] = true;

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    inQueue[u] = false;

                    for (int i = 0; i < graph[u].size(); i++) {
                        Edge e = graph[u].get(i);

                        if (e.capacity > 0 && dist[u] + e.cost < dist[e.to]) {
                            dist[e.to] = dist[u] + e.cost;
                            parentNode[e.to] = u;
                            parentEdge[e.to] = i;

                            if (!inQueue[e.to]) {
                                queue.add(e.to);
                                inQueue[e.to] = true;
                            }
                        }
                    }
                }

                if (dist[sink] == Integer.MAX_VALUE)
                    break;

                int pathflow = Integer.MAX_VALUE;

                for (int v = sink; v != source; v = parentNode[v]) {
                    Edge e = graph[parentNode[v]].get(parentEdge[v]);
                    pathflow = Math.min(pathflow, e.capacity);
                }

                for (int v = sink; v != source; v = parentNode[v]) {
                    Edge e = graph[parentNode[v]].get(parentEdge[v]);

                    e.capacity -= pathflow;
                    graph[v].get(e.rev).capacity += pathflow;
                }

                flow += pathflow;
                cost += pathflow * dist[sink];
            }

            return new int[]{
                    flow, cost
            };
        }
    }

    public static void main(String[] args) {
        int nodes = 4;
        MCMF mcmf = new MCMF(nodes);

        mcmf.addEdge(0, 1, 2, 1);
        mcmf.addEdge(0, 2, 1, 2);
        mcmf.addEdge(1, 2, 1, 1);
        mcmf.addEdge(1, 3, 1, 3);
        mcmf.addEdge(2, 3, 2, 1);

        int[] result = mcmf.minCostMaxFlow(0, 3);

        System.out.println("Max Flow = " + result[0]);
        System.out.println("Min Cost = " + result[1]);
    }
}
