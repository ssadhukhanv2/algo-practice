package com.ssadhukhanv2.sort;

public class FindDuplicateNumber {

    /*
    * https://leetcode.com/problems/find-the-duplicate-number/
    * */
    public static void main(String[] args) {

        int[] arr = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(arr));


    }

    public static int findDuplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        //System.out.println(Arrays.toString(arr));
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return arr[i];
            }
        }

        return -1;
    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
