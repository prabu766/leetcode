package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] 
 * Output: true 
 * 
 * Example 2: 
 * Input: nums = [1,2,3,4] 
 * Output: false 
 * 
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2] 
 * Output: true
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class ContrainsDuplicate {

	public static void main(String[] args) {
		int[] intArr = { 2, 11, 3, 6, 2 };
		System.out.println(containsDuplicate(intArr));
	}

	public static boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			if (countMap.putIfAbsent(i, 1) != null) {
				return true;
			}
		}
		return false;
	}
}
