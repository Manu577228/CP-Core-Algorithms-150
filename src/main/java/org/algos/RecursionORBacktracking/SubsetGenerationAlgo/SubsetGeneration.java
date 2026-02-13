package org.algos.RecursionORBacktracking.SubsetGenerationAlgo;

//Subset Generation is a recursive technique to generate all possible
//        subsets of a given set by making an
//        include / exclude decision for every element.

//          Algorithm Explanation
//
//        Each element has two choices:
//        → include it in the current subset
//        → exclude it from the current subset
//
//        We process elements one by one using recursion
//
//        When all elements are processed, the current subset becomes one valid answer
//
//        This naturally forms a binary recursion tree

import java.util.*;

class SubsetGeneration {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        List<Integer> curr = new ArrayList<>();

        generate(0, arr, curr);
    }

    static void generate(int idx, int[] arr, List<Integer> curr) {
        if (idx == arr.length) {
            System.out.println(curr);
            return;
        }

        curr.add(arr[idx]);
        generate(idx + 1, arr, curr);
        curr.remove(curr.size() - 1);

        generate(idx + 1, arr, curr);
    }
}


