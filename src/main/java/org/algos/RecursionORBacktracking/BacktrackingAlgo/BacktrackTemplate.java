package org.algos.RecursionORBacktracking.BacktrackingAlgo;

//Backtracking is a recursive technique that builds solutions
//        step by step and removes choices when they lead to invalid or complete states.
//        It explores all possibilities by choose → recurse → unchoose.

//               Algorithm :
//
//        Start with an empty/initial state
//
//        At each step, try all possible choices
//
//        Add one choice to the current state
//
//        Recurse to explore further
//
//        After recursion, remove the choice (backtrack)
//
//        Continue until all possibilities are explored

import java.io.*;
import java.util.*;

class Main {

    static int[] a = {1, 2};
    static List<Integer> curr = new ArrayList<>();

    public static void main(String[] args) {
        backtrack(0);
    }

    static void backtrack(int i) {
        if (i == a.length) {
            System.out.println(curr);
            return;
        }

        curr.add(a[i]);
        backtrack(i + 1);
        curr.remove(curr.size() - 1);

        backtrack(i + 1);
    }
}
