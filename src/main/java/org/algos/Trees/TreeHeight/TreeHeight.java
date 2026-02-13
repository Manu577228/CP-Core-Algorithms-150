package org.algos.Trees.TreeHeight;

//Tree Height is the maximum number of edges (or levels)
//        from the root node to the deepest leaf node.
//        It measures how “tall” a tree is.

//          Algorithm Explanation
//
//        Height of an empty tree is -1
//
//        Height of a leaf node is 0
//
//        For any node:
//
//        Recursively compute height of left subtree
//
//        Recursively compute height of right subtree
//
//        Take the maximum of both
//
//        Add 1 for the current node
//
//        This ensures the longest root-to-leaf path is counted

import java.io.*;

class Main {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    static int height(Node root) {
        if (root == null) return -1;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        int h = height(root);

        System.out.println(h);
    }
}
