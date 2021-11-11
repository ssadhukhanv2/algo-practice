package com.ssadhukhanv2.recursion;

public class FibonacciNumber {

    /*
     *
     * https://youtu.be/M2uO2nMT0Bk?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=3181
     *
     * Fibonacci Sequence is something like
     * 0 1 1 2 3 5 8 13 21 ......... N
     * We want to find the N th Fibonacci Number
     * So
     * Fib(N)=Fib(N-1)+Fib(N-2)   <=This is called RECURRENCE RELATION(When recursion is expressed as mathematical formulae)
     * where N is the position of the element in the fibonacci sequence
     * Example:
     * the fibonacci element at the 5th position will be the sum of fibonacci elements at 4th & 3rd position
     * Fib(5)=Fib(4)+Fib(3)
     *     5 = 3 + 2
     *
     *
     * RECURRENCE RELATION: When recursion is expressed as mathematical formulae
     *                 Example:
     *                 Fib(N)=Fib(N-1)+Fib(N-2)
     * BASE CONDITION: When recursion stops making new calls.
     *                 This is done by implementing what we already know
     *                 For example:
     *                 We know that 1st & 2nd term in the fibonacci sequence is the position of the term itself
     *                 element at 0th position is 0
     *                 element at 1st position is 1
     *                 so we implement the base condition as,
     *                 if the position of the element is less than 2, we return the element
     * */
    public static void main(String[] args) {
        System.out.println(findFibonacci(30));
    }

    public static int findFibonacci(int n) {
        if (n < 2) {//BASE CONDITION
            return n;
        }
        // This is not a TAILED RECURSION, since
        // after executing findFibonacci(n - 1)
        // we need to execute findFibonacci(n - 2) after it
        return findFibonacci(n - 1) + findFibonacci(n - 2);

    }
}