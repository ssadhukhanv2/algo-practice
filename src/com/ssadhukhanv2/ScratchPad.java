package com.ssadhukhanv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScratchPad {
    public static void main(String[] args) {

        List<Integer> listInt = IntStream.range(3, 50000).filter((n) -> n % 3 == 0).boxed().collect(Collectors.toList());
        Integer[] arrAscend = new Integer[listInt.size()];
        listInt.toArray(arrAscend);
        System.out.println(Arrays.toString(arrAscend));
        int target = 372;
        System.out.println(infiniteSearch(arrAscend, target));
        System.out.println(arrAscend[infiniteSearch(arrAscend, target)]);


        int[] arr = {24, 69, 71, 99, 150, 78, 67, 36, 26, 19};
        int peakIndex = findPeakIndexElementInMountainArray(arr);
        System.out.println(arr[peakIndex]);
        target = 19;
        if (arr[peakIndex] == target) {
            System.out.println(peakIndex);
        } else {
            int targetIndex = binarySearchInMountainArray(arr, target, 0, peakIndex);
            if (targetIndex == -1) {
                targetIndex = binarySearchInMountainArray(arr, target, peakIndex + 1, arr.length - 1);
            }
            System.out.println(targetIndex);
        }


//        int[] arr = {1, 2, 0};
//        System.out.println(findMissingPossitive(arr));

        arr = new int[]{3, 4, -1, 1};
        System.out.println("Missing Positive: " + findMissingPossitive(arr));
        arr = new int[]{7, 8, 9, 11, 12};
        System.out.println("Missing Positive: " + findMissingPossitive(arr));


    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private static int findMissingPossitive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }

    public static int binarySearchInMountainArray(int[] arr, int target, int start, int end) {
        boolean ascending = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (ascending) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int findPeakIndexElementInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static int infiniteSearch(Integer[] arr, int target) {
        int start = 0;
        int end = 1;
        try {
            while (arr[end] < target) {
                int nStart = end + 1;
                end = nStart * 2;
                start = nStart;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
        return binarySearch(arr, target, start, end);
    }

    public static int binarySearch(Integer[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
