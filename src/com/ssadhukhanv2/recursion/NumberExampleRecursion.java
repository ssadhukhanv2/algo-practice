package com.ssadhukhanv2.recursion;

public class NumberExampleRecursion {
    public static void main(String[] args) {
        /*
         * Print all numbers starting from 1 to 5
         * */
        print(1);
    }



    public static void print(int n) {
        if (n == 5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);

        // This is not a TAILED RECURSION, since there is no function call
        // with print(n + 1)
        print(n + 1);
    }
}
