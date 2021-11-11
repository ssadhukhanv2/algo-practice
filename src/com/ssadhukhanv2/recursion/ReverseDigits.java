package com.ssadhukhanv2.recursion;

public class ReverseDigits {

    //https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=2900
    static int sum = 0;

    static void reverseUsingExternalVariable(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseUsingExternalVariable(n / 10);
    }


    public static void main(String[] args) {
        //Uses External Variable to Reverse
        reverseUsingExternalVariable(66565687);
        System.out.println(sum);

        //No External Variable used to reverse
        System.out.println(reverse(66565687));

        //Check Palindrome
        System.out.println(checkPalindrome(66565687));
        System.out.println(checkPalindrome(6656566));

    }
    static boolean checkPalindrome(int n) {
        return  n==reverse(n);
    }
    static int reverse(int n) {
        //Sometimes additional variables may be needed in argument, in that case separate function is required
        //This is why we have the helper() function which helps us create the value of sum at each step and return it
        int digits = (int) Math.log10(n) + 1;//This returns the digits in n, we need to multiple the sum with 10^(digits-1)
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return sum = (int) (rem * Math.pow(10, digits - 1) + helper(n / 10, digits - 1));

    }


}
