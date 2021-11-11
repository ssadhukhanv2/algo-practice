package com.ssadhukhanv2.search.binary;

public class SearchInRotatedArray {
    /*
    * Hint
    *
    * Find the Pivot
    * Pivot is the maximum element of the array which is not the end element of the Array
    * If Pivot is not found then it means that the array is not rotated
    * If element is at the pivot, then return pivot
    * If element is not at the pivot & element at start is less than the element, then search on the left side of the pivot
    * If element is not at the pivot & element at start is greater than the element, then search on the right side of the pivot
    *
    *
    * How to find the Pivot
    * !!Do Binary Search!! while(start<=end)
    * Mid =start+(end-mid)/2
    *
    * case 1: if arr[mid]>arr[mid+1] then pivot is mid
    * case 2: if arr[mid-1]>arr[mid] then pivot is mid-1
    *
    * But now we need some condition to adjust the the value of start/end at each iteration
    * So we compare the value of mid with the start element and adjust start & end
    * If  elements[mid] <= elements[start]
        * then all values before mid are greater than mid(and pivot would be one of those value)
        * so we shift our end = mid-1
        // The = is put for boundary scenario, so that scenario like end<start is created,
        // which breaks the loop and returns -1, which also indicates the array
        // doesn't have a peak as it's a regular non-rotated array
    * If  elements[mid] > elements[start]
        * then all values after mid would be greater than mid(and pivot would be one of those value)
        * so we shift our start = mid + 1;
    * */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 3};
        int target = 15;
        System.out.println(search(arr, target));

    }

    public static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        int targetIndex = -1;
        arr = new int[]{18, 21, 24, 27, 30, 33, 36, 39, 3, 6, 9, 12, 15};
        if (pivot == -1) {
            // If Pivot Element is not found
            // Treat Array as Non-Rotated Array and Perform Search
            targetIndex = binarySearch(arr, target, 0, arr.length - 1);
        } else if (arr[pivot] == target) {
            // If Pivot Element == target element, return pivot position
            targetIndex = pivot;
        } else if (target < arr[0]) {
            // If target is < start then perform Binary Search on the elements right side of
            // of the target
            targetIndex = binarySearch(arr, target, pivot + 1, arr.length - 1);
        } else {
            // If target > start then perform Binary Search on the elements right side of of
            // the target
            targetIndex = binarySearch(arr, target, 0, pivot - 1);
        }
        return targetIndex;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findPivot(int[] arr) {
        //Pivot is the largest element in the array
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(start + " " + mid + " " + end);
            // Two cases to compare the value of mid with the values after it and before it
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // comparing mid with value after it
                // this mean id mid>m+1, then
                // all values after mid would be less than mid
                index = mid;
                break;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                // comparing mid with value before it
                // this means if mid<m-1, then
                // all values before mid greater than mid
                index = mid - 1;
                break;
            }

            /*
            Now if array exists like [2,2,2,2,9]
            and we rotate the array twice
            [2,9,2,2,2]
            If there are duplicates in teh array then the
            arr[MID],arr[START] & arr[END] will be EQUAL
            and so the below condition will not work
            */

            //Next two cases to shift the value of start & end
            //int[] arr = new int[]{3, 4, 5, 7, 1, 2};
            if (arr[mid] <= arr[start]) {
                // If mid < start, then all values before mid are greater than mid(and pivot
                // would be one of those value)
                // so we shift our end to mid-1
                // The = is put for boundary scenario, so that scenario like end<start is
                // created, which breaks the loop and returns -1, which also indicates the array
                // doesn't have a peak as it's a regular non-rotated array
                end = mid - 1;
            } else {
                // If mid > start, then all values after mid are greater than mid(and pivot
                // would be one of those value)
                // so we shift our start to mid+1
                start = mid + 1;
            }

        }
        return index;
    }
}
