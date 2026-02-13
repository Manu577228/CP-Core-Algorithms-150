package org.algos.LinkedList.SinglyLinkedListAlgo;

//A Singly Linked List is a linear data structure where each node stores
// data and a reference to the next node.
//        Traversal is possible only in one direction (from head to tail).

//Algorithm Explanation
//
//        Each element is stored in a node
//
//        Every node has:
//
//        data → actual value
//
//        next → reference to next node
//
//        The list starts with a head
//
//        Traversal begins from head and moves using next
//
//        Last node points to null

import java.io.*;

class Main {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) throws Exception {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        head.next = second;
        second.next = third;

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
