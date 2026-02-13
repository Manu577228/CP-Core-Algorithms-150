package org.algos.Trees.BinarySearchTreeAlgo;

//A Binary Search Tree (BST) is a binary tree where for every node:
//        left subtree values < node and right subtree values > node.

//        How the BST Algorithm Works
//
//        Start with an empty tree
//
//        Insert the first value as the root
//
//        For every new value:
//
//        If value < current node, move left
//
//        If value > current node, move right
//
//        Repeat until a null position is found
//
//        Insert the node there
//
//        This ordering enables fast search, insert, and delete

import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
            left = right = null;
        }
    }

    static Node insert(Node root, int v) {
        if (root == null) {
            return new Node(v);
        }

        if (v < root.val) {
            root.left = insert(root.left, v);
        } else if (v > root.val) {
            root.right = insert(root.right, v);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        int[] a = {5, 3, 7, 2, 4};

        for (int x : a) {
            root = insert(root, x);
        }

        inorder(root);
    }
}