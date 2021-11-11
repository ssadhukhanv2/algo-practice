package com.ssadhukhanv2.sort;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * For Example for the array: {9, 6, 4, 2, 3, 5, 7, 0, 1}
 * We need to return 8
 * <p>
 * We know that here the index of the array would be equal to the array if the array is sorted
 * GIVEN ARRAY:  {9, 6, 4, 2, 3, 5, 7, 0, 1}
 * SORTED ARRAY: {0, 1, 2, 3, 4, 5, 6, 7, 9}
 * So the missing element here is 8
 * (This can be easily determined by looping through the array
 * if the element in a position is not equal to the value of the position then return the Position)
 *
 * https://leetcode.com/problems/missing-number/
 *
 **/


public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                // If there is an element missing in the array
                // and the missing element is not the terminal element,
                // then there will be a condition
                // where  arr[i]==arr.length
                // this will lead to index out of bounds exception which is why we have added the below condition
                // arr[i]<arr.length
                // we can see that putting all the other elements in their correct place,
                // by sorting them with other elements by our cyclic sort logic
                // will automatically put element=arr.length
                // in it's correct place
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }
        // If control reaches here, this means,
        // all the elements till the end of the array are in their correct position
        // so, the element with value "arr.length" is missing
        // so we return that value
        return arr.length;


    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

}
