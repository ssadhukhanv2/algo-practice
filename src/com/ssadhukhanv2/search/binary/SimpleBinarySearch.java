package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class SimpleBinarySearch {
    public static void main(String[] args) {
        int[] arrAscend = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 22;
        System.out.println(String.format("Array: %s, Target: %d", Arrays.toString(arrAscend), target));
        System.out.println(String.format("Target Found at index %d", new SimpleBinarySearch().binarySearch(arrAscend, target)));

    }


    public int binarySearch(int[] arr, int target) {

        /*
         * We assume here that the array given would be sorted in ascending order with no duplicates
         * If you don't understand binary search watch https://youtu.be/f6UU7V3szVw?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ
         * */

        /*
         * BINARY SEARCH SIMPLIFIED Approach:
         * In Binary Search for Ascending array we basically
         * increase START or decrease END based on the value of mid
         * We have two boundary condition
         * 1) START<=END, this is when we break out of the loop(implemented as loop condition)
         * 2) TARGET= arr[MID], where we can store the index and break
         * If we don't find the TARGET, the index value is returned as -1
         */
        int foundIndex = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                foundIndex = mid;
                break;
            }
        }
        return foundIndex;

    }
}
