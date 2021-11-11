package com.ssadhukhanv2.sort;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 */

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        //Here we se that the array has duplicate elements
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDissappearedNumber(arr));

        arr = new int[]{8, 6, 4, 2, 8, 8, 7, 1};
        System.out.println(findDissappearedNumber(arr));


    }

    private static List<Integer> findDissappearedNumber(int[] arr) {
        List<Integer> dissappearedList = new ArrayList<Integer>();
        int i = 0;
        while (i < arr.length) {
            //cyclic sort
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                dissappearedList.add(i + 1);
            }
        }
        return dissappearedList;
    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
