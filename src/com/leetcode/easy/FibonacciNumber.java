package com.leetcode.easy;

/**
 * 
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * Given n, calculate F(n).
 * 
 * Example 1: 
 * Input: n = 2 Output: 1 
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * Example 2: 
 * Input: n = 3 
 * Output: 2 
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * Example 3: 
 * Input: n = 4 
 * Output: 3 
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fib(3));
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fn = 0;
		int firstNum = 0;
		int secondNum = 1;
		int index = 0;
		while (index <= (n - 2)) {
			fn = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = fn;
			++index;
		}
		return fn;
	}

}
