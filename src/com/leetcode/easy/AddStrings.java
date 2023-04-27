package com.leetcode.easy;

/**
 * 
 * Given two non-negative integers, num1 and num2 represented as string, return
 * the sum of num1 and num2 as a string.
 * 
 * You must solve the problem without using any built-in library for handling
 * large integers (such as BigInteger). You must also not convert the inputs to
 * integers directly.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num1 = "11", num2 = "123" Output: "134" Example 2:
 * 
 * Input: num1 = "456", num2 = "77" Output: "533" Example 3:
 * 
 * Input: num1 = "0", num2 = "0" Output: "0"
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("123456789", "987654321"));
	}

	public static String addStrings(String num1, String num2) {
		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();
		int num1Length = num1Arr.length;
		int num2Length = num2Arr.length;
		int length = num1Length > num2Length ? num1Length : num2Length;
		int[] sum = new int[length];
		int remainder =0;
		int index = 0;
		
		while(index < length) {
			int val1 = (num1Length - index) > 0 ? Character.getNumericValue(num1Arr[num1Length - index -1]) :0;
			int val2 = (num2Length - index) > 0 ? Character.getNumericValue(num2Arr[num2Length - index -1]) :0;
			int val = val1 + val2 + remainder;
			if(val >= 10) {
				val = val %10;
				remainder =1;
			}else {
				remainder =0;
			}
			sum[sum.length-index-1] = val;
			++index;
		}
		StringBuilder sb = new StringBuilder();
		for(int sumVal : sum) {
			sb.append(sumVal);
		}
		if(remainder>0) {
			sb.insert(0, 1);
		}
		return sb.toString();
		
	}
}
