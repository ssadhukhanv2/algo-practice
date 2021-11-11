package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class BinarySearchWithDuplicates {
    /*
     * This time the array would have duplicates and we need to find the index of both
     *
     * This can be done via direction search
     * Please note here we are not directly returning value of the mid but storing it in a variable named index
     * This is purposely done to allow the directional serach
     *
     * */
    public static void main(String[] args) {
        int[] arrAscend = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] ans = new BinarySearchWithDuplicates().searchDuplicates(arrAscend, target);
        System.out.println(String.format("%d was found at %s", target, Arrays.toString(ans)));
    }

    public int[] searchDuplicates(int[] arr, int target) {
        int[] targetIndexes = new int[2];
        targetIndexes[0] = directionalBinarySearch(arr, target, false);
        targetIndexes[1] = directionalBinarySearch(arr, target, true);
        return targetIndexes;
    }

    public int directionalBinarySearch(int[] arr, int target, boolean searchRight) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target || (arr[mid] == target && searchRight)) {
                /*
                 * When the value searchRight parameter is true,
                 * then even if the element is found,
                 * search on the right side of the array
                 * */
                start = mid + 1;
            }
            if (arr[mid] > target || (arr[mid] == target && !searchRight)) {
                /*
                 * When the value searchRight parameter is false,
                 * then even if the element is found,
                 * search on the right side of the array
                 * */
                end = mid - 1;
            }
            if (arr[mid] == target) {
                /*
                * Here we don't use break as we want to traverse the array
                * till the loop condition is false.
                * This allows the directional search
                * */
                index = mid;
            }
        }
        return index;

    }

}
