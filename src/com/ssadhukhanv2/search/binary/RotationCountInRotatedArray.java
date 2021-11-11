package com.ssadhukhanv2.search.binary;

public class RotationCountInRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 1, 3};
        int target = 15;
        System.out.println(findRotationCount(arr));
    }

    public static int findRotationCount(int[] arr) {
        int peak = findPeak(arr);
        /*
        * Take for example an array
        * [1,2,3,4,5,6,7,8]
        * First Rotation
        * [2,3,4,5,6,7,8,1]
        * Second Rotation
        * [3,4,5,6,7,8,1,2]
        *  0,1,2,3,4,5,6,7
        * Peak element is at 5
        * So rotation count = size of array - 1 -peak element
        * 2 = 8 - 1 - 5
        * */

        return arr.length - 1 - peak;
    }

    public static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start<end){
            int mid =start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if(arr[mid]>arr[start]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return -1;
    }
}
