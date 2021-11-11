package com.ssadhukhanv2.recursion;

import java.util.Arrays;

public class BinarySearchUsingRecursion {

    public static void main(String[] args) {
        int[] arr = {-15, -12, -11, -2, -1, 0, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchWithoutRecursion(arr, 3));
        System.out.println(binarySearchUsingRecursion(arr, -15, 0, arr.length - 1));

    }

    /*
     * */
    public static int binarySearchUsingRecursion(int[] arr, int target, int start, int end) {


        int mid = start + (end - start) / 2;
        //printArray(arr, target, start, mid, end);
        if (start > end) {
            //This is known to us from binary search without recursion,
            //basically the return condition after while loop is exit or the loop exit condition
            return -1;
        }
        if (arr[mid] == target) {
            //This is also known to us from binary search without recursion,
            //basically the exit condition of the while loop
            return mid;
        }
        if (arr[mid] > target) {
            //Reduce the search space by adjusting End
            return binarySearchUsingRecursion(arr, target, start, mid - 1);
        }
        //Reduce the search space by adjusting Start
        return binarySearchUsingRecursion(arr, target, mid + 1, end); //
    }

    public static void printArray(int[] arr, int target, int start, int mid, int end) {
        System.out.println("Start: " + start + ", Mid: " + mid + ", End: " + end + ", Array" +
                Arrays.toString(Arrays.stream(arr, start, end).boxed().toArray()));
    }

    public static int binarySearchWithoutRecursion(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = end - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
