package com.ssadhukhanv2.sort;

import java.util.Arrays;

public class BubbleSort {

    /*
    * Bubble Sort
    *
    * */
    public static void main(String[] args) {
        int[] arr=new int[]{9,8,7,4,3,4,54};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        //Arrays.sort();
    }

    public static void bubbleSort(int[] arr) {
        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            // for each step, max item will come at the last respective index, so we decrement the boundary condition
            //j < arr.length - i
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than the previous item
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }
            // if you did not swap for a particular value of i, it means the array is sorted hence stop the program
            if (!swap) {// !false = true
                break;
            }
        }
    }

}
