package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class SearchInRotatedArrayWithDuplicates {

    /*
     *
     * HINT: !!BINARY SEARCH!!
     *
     *
     * Find the PIVOT element(Here there can be duplicates so pivot would be the 1st occurrence of the highest element in the array)
     *
     * //Pivot is the last occurence of the highest element in the array
     *
     * IF PIVOT is not found then the array is not rotated, so do a normal binary search of the entire array & find the element
     * IF TARGET is found at PIVOT, then return PIVOT
     * IF ELEMENT at START is greater than Target, then element lies on the right side of PIVOT, so search from PIVOT+1 to the END of the array
     * IF ELEMENT at START is less than Target, then element lies on the left side of PIVOT, so search from START to the PIVOT of the array
     *
     *
     *
     * Do a BINARY SEARCH while START<END
     * MID = START+(END-START)/2
     * IF ELEMENT at MID is greater than ELEMENT at MID+1 then MID is the PIVOT so return it
     * IF ELEMENT at MID is less than ELEMENT at MID-1 then MID is the PIVOT so return it
     *
     *
     *
     * All the above is same as searching in a Rotated array where no duplicates are NOT present,
     * but here there are duplicates and there would be conditions like  ELEMENT at START, is equal to the ELEMENT at MID, which is equal to the ELEMENT at END
     * So the below logic of Adjusting the START and END positions in the Binary search WILL NOT WORK
     *  Ex: 9, 9, 9, 2, 9
     *      S     M     E
    * If  elements[mid] <= elements[start]
        * then all values before mid are greater than mid(and pivot would be one of those value)
        * so we shift our end = mid-1
        // The = is put for boundary scenario, so that scenario like end<start is created,
        // which breaks the loop and returns -1, which also indicates the array
        // doesn't have a peak as it's a regular non-rotated array
    * If  elements[mid] > elements[start]
        * then all values after mid would be greater than mid(and pivot would be one of those value)
        * so we shift our end = mid-1


     * ADJUSTING the START & END:
     * IF ELEMENT at START, is equal to the ELEMENT at MID, which is equal to the ELEMENT at END
     *   check if the ELEMENT at START is greater than the ELEMENT at START+1,if so return START as the PIVOT
     *   else check if the ELEMENT at END is less than the ELEMENT at END-1, if so return END-1 as the PIVOT
     *   else narrow the search area by increasing START & decreasing END (START++ END--)
     * ELSE
     *   (the Regular logic for finding pivot in rotated array needs to be implemented here)  //FUZZY LOGIC REWRITE
     *    check if element[MID]>element[START] or (element[START] == element[MID] && arr[MID] > arr[END]),
     *        !!element[MID]>element[START]!!:
     *        all values after mid would be greater than mid(because if element[MID-1]>element[mid] that would be caught in our previous conditions)
     *        !!(element[START] == element[MID] && arr[MID] > arr[END])!!
     *        all values after mid would be greater than mid(because if element[MID-1]>element[mid] that would be caught in our previous conditions)
     *        this means PIVOT would lie on the RIGHT side of MID,then , so we Adjust START=MID+1
     *    otherwise check if element[MID]<element[START]
     *        then all values before mid are greater than mid(because if element[MID+1]>element[mid], it would be caught in our previous conditions),
     *          this means PIVOT would lie on the LEFT side of MID, so we Adjust END=MID-1
     */


    public static void main(String[] args) {
        System.out.println("------------------------1st Condition Used here--------------------------");
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int target = 1;
//        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
//        System.out.println();

        int[] nums = new int[]{ 2, 2, 2, 9, 9, 9};
        int target = 1;
        System.out.println(new SearchInRotatedArrayWithDuplicates().findPivotWithDuplicateElement(nums));

        System.out.println("------------------------2nd Condition Used here--------------------------");
        nums = new int[]{8, 8, 9, 5, 6, 6, 7};
        target = 1;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();

        System.out.println("------------------------Decrease Mid & End --> --------------------------");
        nums = new int[]{2, 2, 2, 2, 9, 2, 2};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();

        System.out.println("------------------------3rd Condition Used here--------------------------");
        nums = new int[]{9, 2, 9, 9, 9};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();


        System.out.println("------------------------4th Condition Used here--------------------------");
        nums = new int[]{2, 2, 2, 9, 2};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();

        System.out.println("------------------------5th Condition Used here--------------------------TRUE || FALSE");
        nums = new int[]{2, 3, 3, 5, 6, 7, 9, 10, 1};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();

        System.out.println("------------------------5th Condition Used here--------------------------FALSE || TRUE");
        nums = new int[]{9, 9, 9, 9, 9, 9, 9, 6, 7};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();

        System.out.println("------------------------6th Condition Used here--------------------------");
        nums = new int[]{9, 10, 1, 2, 3, 3, 5, 6, 7};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();
        System.out.println("------------------------6th Condition Used here--------------------------");
        nums = new int[]{9, 9, 10};
        target = 9;
        System.out.println(String.format("Array: %s  Search Key found at :%d ", Arrays.toString(nums), search(nums, target)));
        System.out.println();


    }

    public static int search(int[] nums, int target) {
        // To search Rotated Array, search the Pivot Element
        // Assuming the array is ascending, Pivot is the highest element of the array
        int pivot = findPivotWithDuplicateElement(nums);
        System.out.println("Pivot: " + pivot);
        if (pivot == -1) {
            // If Pivot Element is not found
            // Treat Array as Non-Rotated Array and Perform Search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (target == nums[pivot]) {
            // If Pivot Element == target element, return pivot position
            return pivot;
        } else if (target < nums[0]) {
            // If target is < start then perform Binary Search on the elements right side of
            // of the target
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        } else {
            // If target > start then perform Binary Search on the elements right side of of
            // the target
            return binarySearch(nums, target, 0, pivot - 1);
        }

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


    public static int findPivotWithDuplicateElement(int[] arr) {
        //Pivot is the last occurence of the highest element in the array
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //First two conditions to check if the values around mid
            if (mid < end && arr[mid] > arr[mid + 1]) {
                System.out.println("First Condition " + start + " " + mid + " " + end);
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                System.out.println("Second Condition " + start + " " + mid + " " + end);
                return mid - 1;
            }

            /*
             * Second two conditions to make decisions on the boundary values of the array
             * But with duplicate elements in the array, there is a chance that
             * when arr[start]==arr[mid]==arr[end]
             * In such event the comparison will not work
             * Ex: 2, 2, 2, 9, 2
             *     S     M     E
             * */
            /*if(arr[start]>=arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }*/
            /*
             * So in such a case when arr[start]==arr[mid]==arr[end]
             * we want to eliminate the first and last element by decreasing start & end
             * So we can implement a condition like below and do
             * start++
             * end--
             * and convert the array into
             * Ex: 2, 2, 9
             *     S  M  E
             */
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                /* But problem is start or end may be the pivot
                 * Ex: 9, 2, 2, 9, 9
                 *     S     M     E
                 * So we need some condition to check if the start & end is the pivot
                 * and return it else increase start and decrease end
                 * This can be done as follows
                 * */
                if (start < end && arr[start] > arr[start + 1]) {
                    /*
                     * If the first element is equal to the mid and end,
                     * and if the first element is greater than the next element,
                     * this means start is the pivot
                     * */
                    /*
                     * Ex: 9, 2, 9, 9, 9
                     *     0     2     4
                     * */

                    System.out.println("Third Condition " + start + " " + mid + " " + end);
                    return start;
                }
                start++;
                if (end > start && arr[end] < arr[end - 1]) {
                    /*
                     * If the last element is equal to the mid and start,
                     * and if the element before the last element is greater than the last element,
                     * this means last-1 is the pivot
                     * */
                    System.out.println("Fourth Condition " + start + " " + mid + " " + end);
                    return end - 1;
                }
                System.out.println("Decrease Mid & End --> " + start + " " + mid + " " + end);
                end--;
            } else {
                /*
                 * Here comes the logic to search using binary-search,
                 * if arr[start]<arr[mid], so left side is sorted, we need to check the right side
                 * start=mid+1;
                 * Example:
                     [2, 3, 3, 5, 6, 7, 9, 10, 1]
                      0           4            8
                                  5  6         8
                 * if arr[start]==arr[mid] then we need to check if arr[mid]>arr[end],
                 * this means elements on the left side of the array where the peak may lie, so
                 *  start = mid+1;
                 * Example:
                     [9, 9, 9, 9, 9, 9, 9, 6, 7]
                      0           4           8
                 * */
                if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                    System.out.println("Fifth Condition " + (arr[start] < arr[mid]) + " " + (arr[start] == arr[mid] && arr[mid] > arr[end]) + " " + start + " " + mid + " " + end);
                    start = mid + 1;
                } else {
                    System.out.println("Sixth Condition " + start + " " + mid + " " + end);
                    /*
                     * Example: 9, 10, 1, 2, 3, 3, 5, 6, 7 // OPPOSITE of arr[start] < arr[mid]
                     *          0            4           8
                     *
                     *  Example: 9  9  10  // OPPOSITE of arr[start] == arr[mid] && arr[mid] > arr[end]
                     *           0      2
                     *              1
                     * */
                    end = mid - 1;
                }

            }
        }
        return -1;

    }

}