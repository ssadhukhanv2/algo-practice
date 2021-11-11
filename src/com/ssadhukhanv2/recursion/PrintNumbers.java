package com.ssadhukhanv2.recursion;

public class PrintNumbers {

    /*
     * https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=160
     * */
    public static void main(String[] args) {
        int n = 89;
        System.out.print("N to 1:");
        printNumber(n);
        System.out.print("\n1 to N:");
        printNumberReverse(n);
    }

    public static void printNumber(int n) {
        /*
         * Prints from n to 1
         * */
        if (n == 0) {
            return;
        }
        System.out.print(" " + n);
        printNumber(n - 1);
    }

    public static void printNumberReverse(int n) {
        /*
         * Prints from 1 to n
         * */
        if (n == 0) {
            return;
        }
        printNumberReverse(n - 1);
        System.out.print(" " + n);
    }
}
