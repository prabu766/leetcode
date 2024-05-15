package com.leetcode.easy;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: true Explanation: 20 = 1 Example 2:
 * 
 * Input: n = 16 Output: true Explanation: 24 = 16 Example 3:
 * 
 * Input: n = 3 Output: false
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(3));
		System.out.println(isPowerOfTwo(31));
	}
	
	public static boolean isPowerOfTwo(int n) {
		double d = n;
		if (d == 1) {
			return true;
		}
		int power = 1;
		while (true) {
			double val = Math.pow(2, power);
			if (val == d) {
				return true;

			} else if (val > d) {
				break;
			}
			++power;
		}
		return false;
	}
}
