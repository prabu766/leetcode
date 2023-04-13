package com.leetcode.medium;

/**
 * Find the second largest in an array
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class SecondLargestInArray {

	public static void main(String[] args) {
		int a[] = { 1, 2, 5, 6, 3, 2 };
		int b[] = { 44, 66, 99, 77, 33, 22, 55 };
		int c[] = {12, 35, 1, 10, 34, 1,10};
		System.out.println(secondLargest(a));
		System.out.println(secondLargest(b));
		System.out.println(secondLargest(c));
	}

	private static int secondLargest(int[] a) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = largest;
		for (int val : a) {
			if (val > largest) {
				secondLargest = largest;
				largest = val;
			}else if(val > secondLargest && val != largest) {
				secondLargest = val;
			}
		}
		return secondLargest;
	}
}
