package org.algos.SearchingAndSorting.LowerBoundAlgo;

//      Lower Bound finds the first index in a sorted array where
//      the element is greater than or equal to a given target.
//      If all elements are smaller than the target, it returns the array size.
//      It is implemented using Binary Search.


//      Algorithm Explanation
//
//      Work on a sorted array
//
//      Use binary search space [0 … n)
//
//      Whenever arr[mid] >= target, move left to find the earliest valid index
//
//      Otherwise, move right

class Main {
    public static void main(String[] args) throws Exception {

        int[] arr = {1, 3, 5, 7, 9};
        int target = 6;

        int n = arr.length;

        int l = 0;
        int r = n;
        int ans = n;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (arr[m] >= target) {
                ans = m;
                r = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(ans);
    }
}
