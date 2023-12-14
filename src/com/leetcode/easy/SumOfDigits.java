package com.leetcode.easy;

/**
 * Find the sum of digits of a positive number.
 * e.g. 10 -> 1 + 0 =1
 *      112 -> 1 + 1 + 2 = 4
 * @author prabhuddha.bhashitha
 *
 */
public class SumOfDigits {

	public static void main(String[] args) {
		int number = 1129;
		System.out.println(sum(number));
	}
	
	public static int sum(int n) {
		if(n==0) {
			return n;
		}
		int remainder = n %10;
		int divider = n/10;
		return remainder + sum(divider);
	}
}
