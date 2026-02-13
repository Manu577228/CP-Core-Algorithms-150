package org.algos.SearchingAndSorting.QuickSortAlgo;

//            Quick Sort is a divide-and-conquer sorting algorithm
//            that selects a pivot element, partitions the array
//            around the pivot, and recursively sorts the left and right subarrays.
//            It is efficient in practice and widely used for large datasets.


//            Algorithm Explanation
//
//            Pick a pivot element (here: last element).
//
//            Rearrange elements so that smaller ones go left of pivot and
//            larger ones go right.
//
//            Recursively apply the same steps to left and right subarrays.

class QuickSort {

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;

    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 6, 2, 7, 4};

        quickSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}