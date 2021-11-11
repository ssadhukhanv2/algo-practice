package com.ssadhukhanv2.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * https://leetcode.com/problems/set-mismatch/
 * */
public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        /*
         * One of the number is missing which means we'll have to
         * return that number along with what it's replaced with
         * So size of array returned would be 2
         * */
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swapByIndex(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                //nums[i] is the duplicate number
                //i+1 is the missing number
                return new int[]{nums[i], i + 1};
            }
        }

        return new int[]{-1, -1};

    }

    private static void swapByIndex(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

}
