package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class FindElementInMountainArray {
    /*
     * Mountain Array is an array that has it elements like so:
     * int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
     * This mean values of elements first increases then decreases
     * So to find the peak element we need to find the largest element after which elements start decreasing
     *
     * With the index of peak element we divide the array into two chucks.
     * 1) 0 to Index of Peak Element
     * 2) (Index of Peak Element+1) to End
     *
     * So we first find out the peakElement of the Mountain Array
     *
     * While the START is less than END, we loop to find the element after which the elements start decreasing
     *  This is done by Adjusting values of START & END
     *  IF element at MID < element at MID+1 THEN adjust START to MID+1
     *  IF element at MID >= element at MID+1 THEN adjust END to MID
     *  (This helps increasing the value of START until such a point in time where the next element is less than start)
     * So in the end START will have the index of PEAK
     *
     * Now we can perform checks on the value of the element at PEAK to find the TARGET !!Oh Yes!! Binary Search is used here!!
     * IF element at PEAK is equal to the target, return peak
     * Binary Search the Left Side of the array from Peak
     * If element is still not found search the right side of the array from Peak
     * */









    public static void main(String[] args) {
        int[] arr = { 24, 69, 71, 99, 150, 78, 67, 36, 26, 19 };
        FindElementInMountainArray findElementInMountainArray=new FindElementInMountainArray();
        int peakIndex=findElementInMountainArray.findPeakIndexInMountainArray(arr);
        System.out.println(String.format("Mountain Array: %s", Arrays.toString(arr)));
        System.out.println(String.format("Peak Index: %d & Peak Element is %d",peakIndex,arr[peakIndex]));
        int target=26;
        int indexOfTarget=findElementInMountainArray.orderAgnosticBinarySearch(arr,target,0,peakIndex );
        if(indexOfTarget==-1){ // If the element is not found in the first part of the Array
            indexOfTarget=findElementInMountainArray.orderAgnosticBinarySearch(arr,target,peakIndex+1,arr.length-1 );
        }
        System.out.println(String.format("Target %d found at index %d",target,indexOfTarget));
    }
    public int orderAgnosticBinarySearch(int[] arr, int target, int start, int end ){
        boolean ascending=arr[start]<arr[end];
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ascending) {
                if (arr[mid] < target) {
                    start=mid+1;
                } else {
                    end=mid-1;
                }
            }else {
                if (arr[mid] < target) {
                    end=mid-1;
                } else {
                    start=mid+1;
                }
            }
            if(arr[mid]==target){
                index=mid;
                break;
            }
        }
        return index;
    }

    public int findPeakIndexInMountainArray(int[] arr){
        int start=0;
        int end =arr.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }else {
                end=mid;
            }
        }
        return start;
    }


}































