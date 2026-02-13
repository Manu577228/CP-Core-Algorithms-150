package org.algos.LinkedList.DoublyLinkedListAlgo;

//A Doubly Linked List is a linear data structure where each node stores
//        data and two references: one to the previous node and one to the next node.
//It allows traversal in both forward and backward directions.

//Algorithm Explanation
//
//        Each node has three parts → prev | data | next
//
//        head points to the first node
//
//        tail points to the last node
//
//        Insertion updates both next and prev links
//
//        Traversal can move:
//
//        Forward using next
//
//        Backward using prev

class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    Node head;
    Node tail;

    void insert(int val) {
        Node n = new Node(val);

        if (head == null) {
            head = n;
            tail = n;
            return;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    void display() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insert(10);
        dll.insert(20);
        dll.insert(30);

        dll.display();
    }
}