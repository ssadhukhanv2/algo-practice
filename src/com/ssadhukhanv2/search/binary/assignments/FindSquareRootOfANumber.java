package com.ssadhukhanv2.search.binary.assignments;


/*
 * use binary-search
 * idea is if mid is the square root of the given number N, then mid*mid==N
 * or, mid=Number/mid
 * So adjust mid based on value of N/mid
 * */

public class FindSquareRootOfANumber {
    public static void main(String[] args) {

        int number = Integer.MAX_VALUE;
        //int sqrt = squareRoot(number);
        int sqrt = (int) Math.sqrt(number);
        System.out.println("Square root of " + number + " is " + sqrt);
        sqrt = squareRoot(number);
        System.out.println("Square root of " + number + " is " + sqrt);
    }

    private static int squareRoot(int number) {
        if (number < 1) {
            return number;
        }
        if (number < 4) {
            return 1;
        }
        int start = 1;
        int end = number / 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (number / mid == number) {
                return mid;
            }
            if (mid > number / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

}
