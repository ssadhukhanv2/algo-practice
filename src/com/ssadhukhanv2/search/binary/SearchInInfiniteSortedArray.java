package com.ssadhukhanv2.search.binary;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchInInfiniteSortedArray {

    /*
     * SOLUTION APPROACH:
     *
     * Issue with Regular Binary Search:
     * Infinite Array means a stream of never ending numbers, which means the LENGTH of the array is unidentified.
     * This means we can't set our initial value of END to the terminal index of the array.
     *
     * Modified approach:
     * So to search a TARGET, we adjust our START to point to the element in the array which is greater
     * or equal to the  target using a loop
     * Initially we take START as 0
     * END as 1
     * We iterate the loop as long as  arr[end]<target
     * In every iteration we adjust the value of END so that SEARCH WINDOW increases by 1 from the previous iteration
     * So value END can be calculated as
     * end=start+(end+1-start)*2;
     * this also means, end =start+(newStart-start)*2
     * Once we are out of the loop we perform binary search on array from the "adjusted" START to "adjusted" END
     *
     * Assumptions for simplifications:
     * The array would be infinite which means there would always be an element after the current element
     *
     * */

    public static void main(String[] args) {

        List<Integer> listInt = IntStream.range(10, 40000).filter((n) -> n % 3 == 0).boxed().collect(Collectors.toList());


        Integer[] arrAscend = new Integer[listInt.size()];
        listInt.toArray(arrAscend);
        System.out.println(Arrays.toString(arrAscend));
        int target = 22233;
        System.out.println(String.format("Element %d found at index: %d", target, new SearchInInfiniteSortedArray().search(arrAscend, target)));
    }

    public int search(Integer[] arr, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;
        //int count = 0;  //This variable prints the number of time the box is shifted
        // condition for the target to lie in the range
        while (target > arr[end]) {
            int newStart = end + 1;// this is my new start
            // double the box value
            // end = previous end + sizeofbox * 2
            end = start + (end + 1 - start) * 2; // value of end =start+(newStart-start)*2 or end=newStart*2
            start = newStart;
            //count++;
            //System.out.println("--"+(end+1-start));
            //System.out.println(String.format("Target: %d, Start: %d, End: %d", target, start, end));

        }
        //System.out.println(count);
        System.out.println(String.format("Target: %d, Start: %d, End: %d", target, start, end));
        return binarySearch(arr, target, start, end);

    }

    public int binarySearch(Integer[] arr, int target, int start, int end) {
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
}
