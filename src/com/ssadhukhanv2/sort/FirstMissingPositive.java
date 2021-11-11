package com.ssadhukhanv2.sort;


import java.util.Arrays;

/*
* https://leetcode.com/problems/first-missing-positive/
*
* Given an unsorted integer array nums, return the smallest missing positive integer.
  You must implement an algorithm that runs in O(n) time and uses constant extra space.
    Example 1:
        Input: nums = [1,2,0]
        Output: 3
    Example 2:
        Input: nums = [3,4,-1,1]
        Output: 2
    Example 3:
        Input: nums = [7,8,9,11,12]
        Output: 1

*   We apply cyclic sort to sort the values.
*   Starts from 1 to n
*
*/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        System.out.println(findMissingPossitive(arr));

        arr = new int[]{3, 4, -1, 1};
        System.out.println(findMissingPossitive(arr));
        arr = new int[]{7, 8, 9, 11, 12};
        System.out.println(findMissingPossitive(arr));
    }

    private static int findMissingPossitive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1; //We assume 1 will be at index 0, 2 at 1, 3 at 2 and so on
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                //Don't swap if the element is negative or zero as they are basically useless to us
                //Also Don't swap if the element is possitive & greater than the array size (IndexOutOfBounds)
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If there are no missing element then we return the next element after the last,
        // since element starts from 1
        // the element after the last element is  arr.length+1
        // Example: {1} then missing element would be 2
        return arr.length+1;
    }

    private static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
