package org.algos.Trees.TreeTraversalsAlgo;

//        Morris Traversal is a binary tree traversal technique that
//        performs Inorder traversal without recursion and without
//        extra space by temporarily modifying tree links.
//        It achieves O(1) auxiliary space by reusing unused null right pointers.

//        Algorithm Explanation :
//
//        Start from the root node.
//
//        If the current node has no left child:
//
//        Visit the node.
//
//        Move to the right child.
//
//        If the current node has a left child:
//
//        Find its inorder predecessor (rightmost node in left subtree).
//
//        If predecessor’s right is null:
//
//        Create a temporary link to current node.
//
//        Move current to left child.
//
//        Else:
//
//        Remove the temporary link.
//
//        Visit the current node.
//
//        Move to right child.
//
//        Repeat until current becomes null.

import java.io.*;

class Main {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static void morrisInorder(Node root) {
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                Node pre = curr.left;

                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        morrisInorder(root);
    }
}
