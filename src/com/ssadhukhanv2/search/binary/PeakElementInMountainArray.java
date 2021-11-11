package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class PeakElementInMountainArray {
    /*
    * Mountain Array is an array that has it elements like so:
    * int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
    * This mean values of elements first increases then decreases
    * So to find the peak element we need to find the largest element after which elements start decreasing
    * */

    public static void main(String[] args) {
        int[] arr = { 24, 69, 71, 99, 150, 78, 67, 36, 26, 19 };
        int peakIndex=new PeakElementInMountainArray().findPeakIndexInMountainArray(arr);
        System.out.println(String.format("Mountain Array: %s", Arrays.toString(arr)));
        System.out.println(String.format("Peak Index: %d & Peak Element is %d",peakIndex,arr[peakIndex]));
    }
    public int findPeakIndexInMountainArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=arr[mid+1]){
                //In Binary Search if the element is greater than target we adjust the end
                end=mid;
            }else{
                //In Binary Search if the element is less than target we adjust the start
                start=mid+1;
            }
        }
        //In the end start==end, which is the peak element
        return  start;
    }
}
