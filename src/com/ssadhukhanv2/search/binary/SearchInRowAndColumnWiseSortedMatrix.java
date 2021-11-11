package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class SearchInRowAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        /*
         * Cue:
         *
         * We implement a search as follows:
         *
         * Initial Position for ROW is taken as  0
         * Initial Position for COL is taken as  ROW[0].length-1
         *
         * We can search by incrementing the value of ROW and decreasing the value of COL to find the index for the target
         * WHILE the value of ROW is greater than or equal to 0 && value of COL is less or equals to ROW[0].length-1
         *   If the target is greater than the current element for ROW COL
         *       INCREASE the ROW by 1
         *   If the target is less than the current element for ROW COL
         *       DECREASE the COL by 1
         *   If the element is found
         *       return the value of ROW and COL
         *
         * */


        /*
        The below matrix has the individual rows and columns sorted in ascending order,
        so the first element of a row may or may not be greater than the last element of the previous row
        */
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        /*
        In below matrix the elements are sorted both row wise & column wise,
        This means is that the 1st element in the next row would be greater than last element of the previous row
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
                */
        System.out.println(Arrays.toString(search(arr, 49)));
    }

    private static int[] search(int[][] arr, int target) {
        int r = 0;
        int c = arr[0].length - 1;
        while (r < arr.length && c >= 0) {
            if (arr[r][c] == target) {
                return new int[]{r, c};
            }
            if (arr[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return new int[]{-1, -1};
    }

}
