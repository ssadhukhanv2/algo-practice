package com.ssadhukhanv2.recursion;

import java.util.ArrayList;

public class SumAndProductOfDigits {
    /*
     * Sum of Digits
     * https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=1525
     * Product of Digits
     * https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=1842
     * */
    public static void main(String[] args) {

        int n = 9878745;
        System.out.println("Sum of Digits " + sumOfDigits(n));
        System.out.println("Product of Digits " + productOfDigits(n));
        //System.out.println("Reverse of Digits " + reverseANumber(n));
    }


    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    public static int productOfDigits(int n) {
        if (n % 10 == n) {
            return n;
        }
        return n % 10 * productOfDigits(n / 10);
    }
}
