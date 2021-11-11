package com.ssadhukhanv2.search.binary;

public class SplitArrayLargestSum {
    /*
     * Hint:
     *
     * !!Binary Search!!
     * If the array is to be split to find the minimum largest sum of subarrays.
     * MINIMUM VALUE of MINIMUM LARGEST SUM would be "Largest Element in the Array" (when NUMBER OF SUBARRAYS=size of the array)
     * MAXIMUM VALUE of MINIMUM LARGEST SUM would be "Sum of all Elements in the Array" (when NUMBER OF SUBARRAYS=1)
     * So the MINIMUM LARGEST SUM based on the NUMBER OF SUBARRAYS would be somewhere between the MINIMUM & MAXIMUM VALUE
     *
     *
     * START=Largest Element in the Array
     * END=Sum of all elements in the Array
     * We apply binary search
     *
     * Loop while (START<END)
     * MID= START+(END-START)/2
     *
     * Loop through all elements in the array to figure out,
     * the value of maximum number of sub-arrays required,
     * so that sum of sub-array is not greater than the current mid
     *
     * Now we need to Adjust the value of start & end
     *
     * IF number of subarrays > maximum allowed number of subarrays,
     * then START should be increased(Max value of sum lies on the right of mid)
     * start = mid+1;
     * ELSE, the END needs to be decreased(Max value of sum lies on the left of mid or the mid value)
     * end = mid;
     * */


    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 5, 10, 8};
        System.out.println(findLargestSum(arr, 2));
    }
    /*
     * If the array is to be split to find the minimum largest sum of subarrays.
     * MINIMUM VALUE of MINIMUM LARGEST SUM would be "Largest Element in the Array" (when NUMBER OF SUBARRAYS=size of the array)
     * MAXIMUM VALUE of MINIMUM LARGEST SUM would be "Sum of all Elements in the Array" (when NUMBER OF SUBARRAYS=1)
     * So the MINIMUM LARGEST SUM based on the NUMBER OF SUBARRAYS would be somewhere between the MINIMUM & MAXIMUM VALUE
     * We apply binary search to find out this value
     * */


    private static int findLargestSum(int[] arr, int numberOfSubArrays) {
        int start = 0;
        int end = 0;
        for (int num : arr) {
            start = Math.max(start, num);//Largest Element in the Array
            end += num;//Sum of all the elements in the Array
        }


        while (start < end) {
            int mid = start + (end - start) / 2; //We initially assume MID to be the MINIMUM LARGEST SUM and then work around it
            int sum = 0;
            int pieces = 1;
            for (int num : arr) {

                //Here we are check the sum of each individual subarrays and find how many pieces of
                // subarrays would be needed to keep that value of MINIMUM LARGEST SUM
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            // If the number of pieces required exceeds the allowed number of pieces, then we need to increase mid
            // which means the number of sub-arrays required to create the current maximum sum is greater than
            // the maximum allowed number of array, we need to increase the mid which is the current maximum sum in the array
            if (pieces > numberOfSubArrays) {
                start = mid + 1;
            } else {
                // else mid is the value
                end = mid;
            }

        }
        return end;
    }
}
