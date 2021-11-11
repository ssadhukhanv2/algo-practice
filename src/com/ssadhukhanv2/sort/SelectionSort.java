package com.ssadhukhanv2.sort;

import java.util.Arrays;

public class SelectionSort {
    /*
     * We iterate the array and at each step,
     *       find the largest element in the UNSORTED array and put it in the CORRECT PLACE
     *       here CORRECT PLACE would be the LAST POSITION of UNSORTED ARRAY
     *       the length of the UNSORTED ARRAY decreases with each Iteration as the items are put
     *       in their CORRECT PLACE
     *
     * Example take an array
     * {4, 5, 1, 2, 3}
     * Initially we assume that the entire array is UNSORTED
     * {4, (5), 1, 2, 3}
     * So basically the largest element of the UNSORTED array: 5 will be put at index arr.length-1
     * Now:
     * UNSORTED ARRAY           SORTED ARRAY
     * {(4), 1, 2, 3}           {5}
     * Now LARGEST ELEMENT in the UNSORTED ARRAY is 4 & it's put in the correct place so,
     * UNSORTED ARRAY           SORTED ARRAY
     * {1, 2, (3)}              {4, 5}
     * and so on
     * UNSORTED ARRAY           SORTED ARRAY
     * {1, (2)}                 {3, 4, 5}
     * {(1)}                    {2, 3, 4, 5}
     * {}                       {1,2, 3, 4, 5}
     *
     * Eventually by final iteration the UNSORTED ARRAY is EMPTY
     * & SORTED ARRAY looks like:
     * {1,2, 3, 4, 5}
     *
     *
     * */
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{-8, 5, 1, -4, 3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));


        arr = new int[]{};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int maxIndex = getMaxIndex(arr, 0, last);//Start will always be zero
            swapByIndex(arr, maxIndex, last);
        }

    }

    private static void swapByIndex(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int maxIndex = 0;
        for (int i = start; i < last + 1; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
