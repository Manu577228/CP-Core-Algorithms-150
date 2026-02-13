package org.algos.LinkedList.ReverseALinkedList;

//Reversing a linked list means changing the direction of links
//        so the last node becomes the first.
//        Each node’s next pointer is redirected to its previous node.

//Algorithm Explanation
//
//        Start with three pointers: prev, curr, next
//
//        curr points to current node being processed
//
//        Save curr.next into next (to not lose the list)
//
//        Reverse the link: point curr.next to prev
//
//        Move prev and curr one step forward
//
//        Repeat until curr becomes null
//
//        prev becomes the new head

class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        print(head);

        head = reverse(head);

        print(head);
    }
}