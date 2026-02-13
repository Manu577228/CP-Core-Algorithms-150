package org.algos.LinkedList.FloydsCycleDetectionAlgo;

//Cycle detection in a linked list checks whether any node is
//        revisited while traversing the list.
//        If revisited, the linked list contains a cycle (loop).

//Algorithm Explanation :
////
////        Use two pointers: slow and fast
////
////        slow moves 1 step at a time
////
////        fast moves 2 steps at a time
////
////        If the list has no cycle, fast will reach null
////
////        If the list has a cycle, slow and fast will meet at some node
////
////        Meeting point ⇒ Cycle exists

class Node {
    int val;
    Node next;

    Node(int v) {
        val = v;
        next = null;
    }
}

class CycleDetection {

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
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(hasCycle(a));
    }
}