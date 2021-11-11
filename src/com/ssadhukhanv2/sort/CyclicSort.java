package com.ssadhukhanv2.sort;

import java.util.Arrays;


// For a continuous array of elements with increment of 1, starting at 1
// for element "n", which is at position "i"
// n=i+1
// So i=n-1
// For example:
// ARRAY:       { 1, 2, 3, 4, 5 }
// POSITION:    { 0, 1, 2, 3, 4 }
// So we use this logic and implement CYCLIC SORT

/**
 * CYCLIC SORT
 * Cyclic sort assumes that the array is of size N with elements 1, 2, 3, 4, 5 ....... N-1
 * We iterate through all elements in the array "i" being the index counter
 * Store the value of the correct position for arr[i] when is arr[i]-1 in a variable say "correctIndex"
 * So, correctIndex=arr[i]-1;
 * if the element is NOT in correct position arr[i] != arr[correctIndex]
 * swap the elements at i & correctIndex
 * This will sort the Array!!!
 */


public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 1, 2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
