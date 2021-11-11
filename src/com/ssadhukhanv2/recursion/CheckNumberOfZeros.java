package com.ssadhukhanv2.recursion;

public class CheckNumberOfZeros {

    public static void main(String[] args) {
        System.out.println(checkZeros(500065600));
    }

    public static int checkZeros(int n) {
        return checkZerosHelper(n, 0);
    }

    public static int checkZerosHelper(int n, int numberOfZeros) {
        if (n == 0) {
            return numberOfZeros;
        }
//        if (n % 10 == 0) {
//            ++numberOfZeros;
//        }
//        if (n % 10 == n) {
//            return numberOfZeros;
//        }
        int rem = n % 10;
        if (rem == 0) {
            return checkZerosHelper(n / 10, numberOfZeros + 1);
        } else {
            return checkZerosHelper(n / 10, numberOfZeros);
        }
    }
}
