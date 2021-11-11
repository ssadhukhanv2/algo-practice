package com.ssadhukhanv2.search.binary;

import java.util.Arrays;


/*
 * Cue:
 *
 * Implement a Binary Search method that can search a row of a 2D array when the ROW number and ELEMENT is given
 *
 * If the given 2D array is empty, return -1, -1
 * If the given 2D array has a single row the use Binary Search to find element in the 1st row
 *
 * Apply Binary Search to narrow down target area to 2 rows in the array
 * This is done by adjusting the rStart & rEnd, by comparing the value of element at rMid & rCol to the value of the target
 * Then we perform binary search on the rows
 *
 * This can be easily done as follows
 * rStart=0
 * rEnd=Length of 2D array-1
 * cMid=Length of first row/2
 *
 * While the value of rStart is less than rEnd-1 (This allows us to narrow down to 2 rows)
 *  perform binary search on the cMid th element at each row
 *  rMid=rStart+(rEnd-rStart)/2
 *  The value of rEnd & rStart may be adjusted by conventional binary search comparisons like so
 *      If element at rMid rCol greater than target, then target lies in a row lower than current row,
 *          so we increase value of rStart (rStart=rMid)
 *      If element at rMid rCol is less than target, then target lies in a row above than current row,
 *          so we decrease value of rEnd (rEnd=rMid)
 *      If target is found at rMid rCol
 *          we return the value of rMid rCol
 *
 * If we have not found the target in the above loop this means if the target exists in the array,
 * it will be any one of the element in rStart & rEnd
 *
 * So we perform binary Search on the those two rows.
 * But since we strive to improve the time complexity, we divide the rows into 6 quadrants based on cMid
 * and perform binary search on the 6 quadrants
 *      element at [rStart][cMid]
 *      element at [rStart+1][cMid]
 * if target is less than element at the middle column of the first row, search
 *      elements from [rStart][0] to [rStart][cMid-1]
 * if target is greater than element at the middle column of the first row and less than element at end column of the first row
 *      elements from [rStart][cMid+1] to [rStart][length of row-1]
 * if target is less than element at the middle column of the second row, search
 *      elements from [rStart+1][0] to [rStart+1][length of row-1]
 * if target is greater than element at the middle column of the second row, and less than element at end column of the seconf row
 *      elements from [rStart+1][cMid+1] to [rStart+1][length of row-1]
 * */


public class BinarySearchInSortedMatrix {

    public static void main(String[] args) {
        /*
        In below matrix the elements are sorted both row wise & column wise,
        This means is that the 1st element in the next row would be greater than last element of the previous row
        */
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        /*
        The below matrix has the individual rows and columns sorted in ascending order,
        so the first element of a row may or may not greater than the last element of the previous row
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };*/
        System.out.println(Arrays.toString(search(arr, 11)));
    }

    private static int[] binarySearchInRow(int[][] arr, int row, int cStart, int cEnd, int target) {
        /*
         * Binary Search in a row
         * */
        while (cStart <= cEnd) {
            int cMid = cStart + (cEnd - cStart) / 2;
            if (target == arr[row][cMid]) {
                return new int[]{row, cMid};
            }
            if (target > arr[row][cMid]) {
                cStart = cMid + 1;
            } else {
                cEnd = cMid - 1;
            }
        }
        return new int[]{-1, -1};
    }


    private static int[] search(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        /*
         * If there are no columns, then target can't be found
         * */
        if (cols == 0) {
            return new int[]{-1, -1};
        }

        /*
         * If there is just a single row search that row
         * */
        if (rows == 1) {
            return binarySearchInRow(arr, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;


        /*
         * Apply Binary Search to narrow down target area to two rows in the array
         * This is done by adjusting the rStart & rEnd according to the value of the target
         * Then we perform binary search on the rows
         * */
        while (rStart < rEnd - 1) {
            int rMid = rStart + (rEnd - rStart) / 2;
            if (arr[rMid][cMid] == target) {
                return new int[]{rMid, cMid};
            }
            if (arr[rMid][cMid] > target) {
                rEnd = rMid;
            } else {
                rStart = rMid;
            }
        }

        //System.out.println(rStart+" "+cMid);

        /*
         * If the element lies in the first row and middle column of the target area
         * */
        if (arr[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        /*
         * If the element lies in the second row and middle column of the target area
         * */
        if (arr[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        //First Part
        if (target <= arr[rStart][cMid - 1]) {
            return binarySearchInRow(arr, rStart, 0, cMid - 1, target);
        }

        //Second Part
        if (target >= arr[rStart][cMid + 1] && target <= arr[rStart][cols - 1]) {
            return binarySearchInRow(arr, rStart, cMid + 1, cols - 1, target);
        }

        //Third Part
        if (target <= arr[rStart + 1][cMid - 1]) {
            return binarySearchInRow(arr, rStart + 1, 0, cMid - 1, target);
        }

        //Fourth Part
        if (target >= arr[rStart + 1][cMid + 1] && target <= arr[rStart + 1][cols - 1]) {
            return binarySearchInRow(arr, rStart + 1, cMid + 1, cols - 1, target);
        }


        return new int[]{-1, -1};
    }


}
