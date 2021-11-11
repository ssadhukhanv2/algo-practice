package com.ssadhukhanv2.sort;

import java.util.Arrays;

public class InsertionSort {
    /*
     * Insertion Sort:
     * For each index put that element in their correct position in the Left-Hand Side
     * */
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 1, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                /*
                 * This loops basically compares the current element of the array with the previous element
                 * and for each value of j (i+1 to 0)
                 * if there is an element which is less than the previous element
                 * swaps it
                 *
                 * This results in a sorted array on the left-hand side of the element being compared,
                 * so we BREAK if element is not less than the previous element
                 * and move on to the next element
                 *
                 * Our motivation of sorting is make each element in the array should be greater than the one before it
                 * */
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int sIndex, int eIndex) {
        int temp = arr[sIndex];
        arr[sIndex] = arr[eIndex];
        arr[eIndex] = temp;
    }
}
