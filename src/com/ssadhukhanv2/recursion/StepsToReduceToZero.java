package com.ssadhukhanv2.recursion;

public class StepsToReduceToZero {

    // 1
    // 2 3 4 5 6 7 8 9 1
    //
    /*
    * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    * https://youtu.be/JxILxTwHukM?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=4121
    * */
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
        return numberOfStepsHelper(num, 0);
    }

    public static int numberOfStepsHelper(int num, int stepCount) {
        //System.out.println("--"+num);
        if (num == 0) {
            return stepCount;
        }
        if (even(num)) {
            return numberOfStepsHelper(num / 2, stepCount + 1);
        }
        return numberOfStepsHelper(num - 1, stepCount + 1);
    }

    public static boolean even(int n) {
        return (n & 1) == 0;
    }
}
