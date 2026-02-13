package org.algos.QueueAndDeque.QueueAlgo;

//A Queue is a linear data structure that follows
//FIFO (First In, First Out) order.
//Insertion happens at the rear, and deletion happens from the front.

//How Queue Algorithm Works :
//
//Queue maintains two pointers: front and rear
//
//Enqueue → Add element at the rear
//
//Dequeue → Remove element from the front
//
//Peek → View element at the front
//
//If front > rear → Queue is empty
//
//Operations follow strict FIFO order

import java.io.*;
import java.util.*;

class QueueLinkedList {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}