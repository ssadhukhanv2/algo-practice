package com.ssadhukhanv2.search.binary;

class Solution {
    public int search(int[] arr, int target) {
        int peak=findPeak(arr);
        if(peak==-1){
            return binarySearch(arr,target,0,arr.length-1);
        }else if(arr[peak]==target){
            return peak;
        }else if(arr[0]>target){
            return binarySearch(arr,target,peak+1,arr.length-1);
        }else{
            return binarySearch(arr,target,0,peak);
        }
    }

    public int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>target){
                end=mid-1;
            }else if(arr[mid]<target){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int findPeak(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(end>mid && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(start<mid && arr[mid-1]>arr[mid]){
                return mid+1;
            }
            if(arr[start]<arr[mid]){
                start=mid;
            }else{
                end=mid-1;
            }

        }
        return -1;
    }
}