package org.algos.Stacks.StackAlgo;

//A Stack is a linear data structure that follows LIFO (Last In, First Out).
//Elements are inserted and removed only from the top.

//How the Stack Algorithm Works :
//
//Stack has one accessible end called top
//
//Push → add element at the top
//
//Pop → remove element from the top
//
//Peek → view top element without removing
//
//Operations always happen in constant order from the top

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
       Stack<Integer> st = new Stack<>();

       st.push(10);
       st.push(20);
       st.push(30);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
    }
}