package com.leetcode.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, 8.345 would be truncated to 8, and -2.7335
 * would be truncated to -2.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * Note: Assume we are dealing with an environment that could only store
 * integers within the 32-bit signed integer range: [−231, 231 − 1]. For this
 * problem, if the quotient is strictly greater than 231 - 1, then return 231 -
 * 1, and if the quotient is strictly less than -231, then return -231.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class DivideTwoNumbers {

	public static void main(String[] args) {
		System.out.println(new DivideTwoNumbers().divide(10, 3));
		System.out.println(new DivideTwoNumbers().divide(Integer.MAX_VALUE, 1));
		System.out.println(new DivideTwoNumbers().divide(Integer.MIN_VALUE, 1));
	}

	public int divide(int dividend, int divisor) {

		//if the quotient is strictly greater than 231 - 1, then return 231 - 1
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int quotient = 0;
		int subQuot = 0;

		boolean negative = dividend < 0 ^ divisor < 0;// only one can be negative to be the quotient negative

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		while (dividend - divisor >= 0) {
			subQuot = 0;
			while (dividend - (divisor << subQuot << 1) >= 0) {
				++subQuot;
			}
			quotient = quotient + (1 << subQuot);
			dividend = dividend - (divisor << subQuot);
		}
		return negative ? -quotient : quotient;
	}

}
