package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class OrderAgnosticBinarySearch {

    private static int[] arrDescend;

    public static void main(String[] args) {
        int[] arrAscend = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int[] arrDescend = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int target = 22;
        System.out.println(String.format("Ascending Array: %s, Target: %d", Arrays.toString(arrAscend), target));
        System.out.println(String.format("Target Found at index %d", new OrderAgnosticBinarySearch().orderAgnosticBinarySearch(arrAscend, target)));
        System.out.println(String.format("Descending Array: %s, Target: %d", Arrays.toString(arrDescend), target));
        System.out.println(String.format("Target Found at index %d", new OrderAgnosticBinarySearch().orderAgnosticBinarySearch(arrDescend, target)));

    }

    public int orderAgnosticBinarySearch(int[] arr, int target) {
        int numberOfComparisons=0;
        /*
         * We assume here that the array given would be of either ascending or descending order with no duplicates
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

        int start = 0;
        int end = arr.length - 1;
        boolean ascending = arr[start] < arr[end];
        int targetIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ascending) {
                //Regular Binary Search
                if (arr[mid] > target) {
                    end = mid - 1;
                }
                if (arr[mid] < target) {
                    start = mid + 1;
                }
            } else {
                //Implement Reverse of the Regular Binary Search
                if (arr[mid] > target) {
                    start = mid + 1;
                }
                if (arr[mid] < target) {
                    end = mid - 1;
                }
            }
            if (arr[mid] == target) {
                targetIndex = mid;
                break;
            }
            numberOfComparisons++;

        }
        System.out.println(String.format("Number of Comparisons: %d",numberOfComparisons));
        return targetIndex;
    }

}
