package org.algos.Trees.EulerTourAlgo;

//        Euler Tour is a DFS-based technique where each
//        node in a tree is visited when entered and when exited,
//        producing a linear traversal.
//        It helps convert tree problems into array/range problems.

//         How the Algorithm Works
//
//        Start DFS from the root.
//
//        When a node is first visited → record entry time.
//
//        Traverse all its children recursively.
//
//        When returning back → record exit time.
//
//        Each node appears twice in the Euler tour (enter + exit).
//
//        The traversal is stored in an array (Euler array).


import java.io.*;
import java.util.*;

class Main {

    static int t = 0;
    static int[] in, out, euler;
    static List<Integer>[] g;

    static void dfs(int u, int p) {
        in[u] = t;
        euler[t++] = u;

        for (int v : g[u]) {
            if (v == p) continue;
            dfs(v, u);
            euler[t++] = u;
        }

        out[u] = t - 1;
    }

    public static void main(String[] args) throws Exception {
        PrintWriter outw = new PrintWriter(System.out);

        int n = 3;

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        g[1].add(2);
        g[2].add(1);
        g[1].add(3);
        g[3].add(1);

        in = new int[n + 1];
        out = new int[n + 1];
        euler = new int[2 * n];

        dfs(1, 0);

        outw.println("Euler Tour:");
        for (int i = 0; i < t; i++)
            outw.print(euler[i] + " ");

        outw.println("\nEntry Times:");
        for (int i = 1; i <= n; i++)
            outw.println(i + " -> " + in[i]);

        outw.println("Exit Times:");
        for (int i = 1; i <= n; i++)
            outw.println(i + " -> " + out[i]);

        outw.flush();
    }
}
