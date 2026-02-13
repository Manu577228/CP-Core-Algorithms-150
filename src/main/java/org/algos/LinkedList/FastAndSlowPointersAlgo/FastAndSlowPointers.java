package org.algos.LinkedList.FastAndSlowPointersAlgo;

//Fast & Slow Pointer is a technique where two pointers traverse a linked list at
//        different speeds to detect patterns like cycles or middle nodes.
//        Typically, the slow pointer moves 1 step, while the fast pointer moves 2 steps.

//2) Generic Explanation :
//
//        Initialize two pointers at the head of the linked list.
//
//        Move slow pointer by 1 node at a time.
//
//        Move fast pointer by 2 nodes at a time.
//
//        Because fast moves quicker, it eventually:
//
//        Meets slow → cycle exists
//
//        Reaches null first → no cycle
//
//        The same idea helps find:
//
//        Middle of linked list
//
//        Detect loops
//
//        Find cycle starting point

class FastSlowPointers {

    static class Node {
        int val;
        Node next;

        Node(int v) {
            val = v;
            next = null;
        }
    }

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        boolean result = hasCycle(head);

        System.out.println(result);
    }
}
