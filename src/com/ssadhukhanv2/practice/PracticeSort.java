package com.ssadhukhanv2.practice;

import java.util.Arrays;
import java.util.logging.SocketHandler;

public class PracticeSort {
    /*
     * BubbleSort
     */
    public static void main(String[] args) {
        int[] arr = new int[]{-215, -200, 69, -420, -900, 0, 9999, 451, 45, 48,};
        System.out.println(Arrays.toString(arr));
        //bubbleSort(arr);
        //selectionSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));


        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("\n"+Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int maxIndex = findMaxIndex(arr, 0, last);
            //System.out.println(maxIndex);
            swap(arr, maxIndex, last);
            //System.out.println(Arrays.toString(arr));
        }
    }


    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static int findMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start; i < end + 1; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
