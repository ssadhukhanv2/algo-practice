package com.ssadhukhanv2.recursion;

public class Factorial {

    /*
     * Factorial
     * https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=937
     *
     * Sum of N to 1
     * https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=1417
     * */
    public static void main(String[] args) {
        System.out.println("Factorial: " + fact(5));
        System.out.println("Sum: " + sum(5));
    }

    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int sum(int n) {
        if (n < 1) {
            return 0;
        }
        return n + sum(n - 1);
    }
}
