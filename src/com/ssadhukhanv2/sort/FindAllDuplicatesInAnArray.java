package com.ssadhukhanv2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 */

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));
        arr = new int[]{1, 1, 2};
        System.out.println(findDuplicates(arr));
        arr = new int[]{1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> listWithDuplicates = new ArrayList<Integer>();
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (i < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString( nums));
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                listWithDuplicates.add(nums[i]);
            }
        }
        return  listWithDuplicates;
    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }


}
