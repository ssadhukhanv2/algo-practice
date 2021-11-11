package com.ssadhukhanv2.bitwise;

public class FindOddEven {
    // The LSB of a number would be 1 if the Number is Odd
    // Eg: 7 = 111
    // The LSB of a number would be 0 if the Number is Even
    // Eg: 6 = 110
    // So if given a number N if, N&1==1, then the number is ODD
    // Same way if N&1==0, the number is EVEN
    public static void main(String[] args) {
        System.out.println(checkOdd(2));
    }
    public static boolean checkOdd(int n){
        return (n&1)==1;
    }
}
