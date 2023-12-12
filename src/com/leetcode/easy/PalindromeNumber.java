package com.leetcode.easy;

/**
 * Given an integer x, return true if x is palindrome integer. An integer is a
 * palindrome when it reads the same backward as forward. For example, 121 is a
 * palindrome while 123 is not.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		int number = 954489;
		System.out.println(isPalindrome(number));
		System.out.println(isPalindromeUsingOnlyIntegers(number));
	}

	public static boolean isPalindrome(int x) {
		int tempInt = x;
		if (x < 0) {
			return false;
		} else if (x < 10) {// single digit number
			return true;
		} else {
			StringBuilder sb = new StringBuilder();
			while (tempInt >= 10) {
				sb.append(tempInt % 10);
				tempInt = tempInt / 10;
			}
			sb.append(tempInt);

			return String.valueOf(x).equals(sb.toString());
		}
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindromeUsingOnlyIntegers(int x) {
		
		//get the number of digits in the given number
		int tmp =x;
		int digitCount = 0;
		while(tmp !=0) {
			++digitCount;
			tmp = tmp / 10;
		}
		
		int tempInt = x;
		if (x < 0) {
			return false;
		} else if (x < 10) {// single digit number
			return true;
		} else {
			int sum = 0;
			while (tempInt >= 10) {
				int modulo = tempInt % 10;
				int addVal  = (int)Math.pow(10,--digitCount);
				sum = sum + (modulo * addVal);
				tempInt = tempInt / 10;
			}
			sum += tempInt;
			return sum ==x;
		}
	}
}
