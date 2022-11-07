package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1: ----------- Input: nums = [-1,0,1,2,-1,-4] Output:
 * [[-1,-1,2],[-1,0,1]] Explanation: nums[0] + nums[1] + nums[2] = (-1) + 0 + 1
 * = 0. nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0. nums[0] + nums[3] +
 * nums[4] = (-1) + 2 + (-1) = 0. The distinct triplets are [-1,0,1] and
 * [-1,-1,2]. Notice that the order of the output and the order of the triplets
 * does not matter.
 * 
 * Example 2: -----------
 * 
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does
 * not sum up to 0.
 * 
 * Example 3: -----------
 * 
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
 * triplet sums up to 0.
 *
 * 
 * @author prabhuddha.bhashitha 0,1,2,3,4,5
 * 
 *         0,1,2,3,4,5
 *         
 *         0,1,2
 *         0,2,3
 *         0,3,4
 *         0,4,5
 *         
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] intArr = { 0, 1, -1 };
		System.out.println(threeSum(intArr));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> numLists = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			for (int arrIndex = 0; arrIndex < nums.length - 2; arrIndex++) {
				int val1 = nums[i];
				int val2 = nums[arrIndex + 1];
				int val3 = nums[arrIndex + 2];

				if ((val1 + val2 + val3) == 0) {
					List<Integer> numList = new ArrayList<>();
					numList.add(val1);
					numList.add(val2);
					numList.add(val3);
					numLists.add(numList);
				}
			}
		}
		return numLists;
	}
}
