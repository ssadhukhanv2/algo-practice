package com.ssadhukhanv2.search.binary;

import java.util.Arrays;

public class SmallestLetterGreaterThanTarget {
    /**
     * Same Concept as CEIL, but with character Array
     * Hint: Binary Search
     *
     * We do a binary search  in a loop WHILE  START is still less than or equals to END
     *  Since we need the next greatest letter so we increase start if it's less than or equal to the target
     *      IF the value of ELEMENT at MID is less than or equals to TARGET, increase value of START
     *      (The "equals" condition allows us to store the value of CEIL in START)
     *          START=MID+1;
     *      ELSE DECREASE MID
     *          END=MID-1;
     *  Generally we return value of START but since the letters wrap around
     *  But here we assume letters wrap around so if value of start is greater than value of end we return the starting position
     *  We implement this by returning (START % arr.length)
     *
     */
    public static void main(String[] args) {
        char[] characters = {'a', 'c', 'd', 'g', 'j', 'm', 'p', 'q', 's', 'u', 'w', 'z'};
        char target = 'a';
        System.out.println(String.format("Array: %s, Target: %s", Arrays.toString(characters), target));
        System.out.println(String.format("Smallest Letter Greater Than Target is: %s", characters[new SmallestLetterGreaterThanTarget().smallestLetterGreaterThanTarget(characters, target)]));
    }

    public int smallestLetterGreaterThanTarget(char[] arr, char target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(start>arr.length - 1){
            start=-1;
        }
        return start%arr.length;
    }
}
