package org.algos.SearchingAndSorting.CyclicSortAlgo;

//          Cyclic Sort is an in-place sorting algorithm used when numbers
//          are in the range 1 to N.
//          Each element is placed directly at its correct index
//          by swapping until all elements are positioned correctly.


//          Algorithm Explanation
//
//          Start from index i = 0
//
//          For the current element, calculate its correct index = value − 1
//
//          If the element is not at its correct position, swap it
//
//          Otherwise, move to the next index
//
//          Repeat until the array is sorted

class CyclicSort {

    public static void cyclicSort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correctIndex = arr[i] - 1;

            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};

        cyclicSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
