package org.algos.Greedy.HuffmanCodingAlgo;

//          Huffman Coding is a greedy compression algorithm used to generate optimal prefix
//          codes based on character frequencies.
//          Characters with higher frequency get shorter codes, and those with lower
//          frequency get longer codes, minimizing total encoding length.
//
//      Algorithm Explanation
//
//          Create a min-heap of nodes using character frequencies
//
//          Repeatedly extract two minimum frequency nodes
//
//          Merge them into a new node with summed frequency
//
//          Insert the merged node back into the heap
//
//          Repeat until one node remains → Huffman Tree
//
//          Traverse tree to generate binary codes (0 = left, 1 = right)

import java.util.PriorityQueue;

public class HuffmanCoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (x, y) -> x.freq - y.freq
        );

        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node merged = new Node('-', left.freq + right.freq);

            merged.left = left;
            merged.right = right;

            pq.add(merged);
        }

        Node root = pq.poll();
        printCodes(root, "");

    }

    static void printCodes(Node node, String code) {
        if (node == null) return;

        if (node.ch != '-') {
            System.out.println(node.ch + " : " + code);
        }

        printCodes(node.left, code + "0");
        printCodes(node.right, code + "1");
    }
}
