package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class CeilAndFloor {

    /*
     *
     * SOLUTION APPROACH
     * BINARY SEARCH SIMPLIFIED Approach:
     * In Binary Search for Ascending array we basically
     * increase START or decrease END based on the value of mid
     * We have two boundary condition
     * 1) START<=END, this is when we break out of the loop(implemented as loop condition)
     * 2) TARGET= arr[MID], where we can store the index and break
     * If we don't find the TARGET, the index value is returned as -1

     * CEIL:
     * If we eliminate TARGET= arr[MID] condition and
     * add the logic of = to the arr[MID]<=target comparison
     * if the Element is not found,
     * we get the smallest value, higher than the target in START before the loop break
     * This START would be the CEIL Element Index
     *
     *
     * FLOOR
     * If we eliminate TARGET= arr[MID] condition and
     * add the logic of = to the arr[MID]>=target comparison (REVERSE)
     * if the Element is not found,
     * we get the highest value, smaller than the target in END before the loop break
     * This END would be the FLOOR Element Index
     * */
    public static void main(String[] args) {
        int[] arrAscend = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 22;
        System.out.println(String.format("Array: %s, Target: %d", Arrays.toString(arrAscend), target));
        System.out.println(String.format("Ceil: %d", new CeilAndFloor().ceil(arrAscend, target)));
        System.out.println(String.format("Floor: %d", new CeilAndFloor().floor(arrAscend, target)));
    }

    public int ceil(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                //Equals Condition put in start=mid+1, this will calculate ceil(start) as mid+1, when start=end
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // The loop would be violated when start > end, so start would either have the
        // target or the next greatest element after the target, which is the ceil
        return start;
    }

    public int floor(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else { //This is same as `else if (arr[mid] >= target)`
                //Equals Condition put in start=mid-1, this will calculate ceil(end) as mid-1 when start=end
                end = mid - 1;
            }
        }
        // The loop would be violated when start > end, so end < start and thus end
        // would either have the target or the
        // next smallest element after the target, which is the ceil
        return end;
    }
}
