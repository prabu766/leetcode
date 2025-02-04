package com.leetcode.hard;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums, return the smallest missing positive
 * integer.
 * 
 * You must implement an algorithm that runs in O(n) time and uses constant
 * extra space.
 * 
 * Input: nums = [1,2,0] Output: 3 Explanation: The numbers in the range [1,2]
 * are all in the array.
 * 
 * 
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class MissingSmallestPositive {

	public static void main(String[] args) {

		int[] numArr = { 1, 2, 3, 4, 5,6,7, 13, 12, 9, 10, 11 };
		// int[] numArr = {7,8,9,11,12};
		// int[] numArr = {2,1};
		System.out.println(firstMissingPositive(numArr));
	}

	public static int firstMissingPositive(int[] nums) {

		int smallestPositive = 1;
		Arrays.sort(nums);
		for (int num : nums) {
			if (num == smallestPositive) {
				++smallestPositive;
			}else if(num > smallestPositive) {
				break;
			}
			System.out.println(num);
		}
		return smallestPositive;
	}

}
