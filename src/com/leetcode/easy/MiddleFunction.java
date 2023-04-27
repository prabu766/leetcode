package com.leetcode.easy;

import java.util.Arrays;

/**
 * 
 * Write a function called middle that takes an array and returns a new array
 * that contains all but the first and last elements.
 * 
 * myArray = [1, 2, 3, 4] middle(myArray) # [2,3]
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class MiddleFunction {

	public static void main(String[] args) {
		int[] intArr = { 2, 11, 3, 4, 5 };
		int[] middleArr = middle(intArr);
		System.out.println(Arrays.toString(middleArr));
	}

	public static int[] middle(int[] array) {
		if (array.length > 2) {
			int[] returnArr = new int[array.length - 2];
			for (int i = 1; i <= array.length - 2; i++) {
				returnArr[i - 1] = array[i];
			}
			return returnArr;
		}
		return new int[0];
	}

}
