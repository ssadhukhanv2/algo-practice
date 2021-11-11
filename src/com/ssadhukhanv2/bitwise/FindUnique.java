package com.ssadhukhanv2.bitwise;

public class FindUnique {
    /*
    Find the Unique Element In the Array Where Each Number Occurs Twice.
    One of the element occurs only once
    */

    public static void main(String[] args) {
        // 4^1 gives the complement of 4 which is (9-4)=9
        // 4^0 gives the actual number 4
        // 4^4 gives 0
//        System.out.println((4 ^ 1));
//        System.out.println((4 ^ 0));
//        System.out.println((4 ^ 4));

        // Since N^N is 0, so XOR(^) all the elements in the array would yield the unique number
        // This is because:
        // ^ is associative A^B^C^A^B^C^D == A^A^B^B^C^C^D == 0^0^0^D ==D
        // We make use of this property
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }


}
