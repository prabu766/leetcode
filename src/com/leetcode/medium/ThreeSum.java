package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * Example 1: ----------- 
 * Input: nums = [-1,0,1,2,-1,-4] 
 * Output:[[-1,-1,2],[-1,0,1]] 
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. 
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0. 
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. 
 * 
 * The distinct triplets are [-1,0,1] and
 * [-1,-1,2]. Notice that the order of the output and the order of the triplets
 * does not matter.
 * 
 * Example 2: -----------
 * 
 * Input: nums = [0,1,1] Output: [] 
 * Explanation: The only possible triplet does
 * not sum up to 0.
 * 
 * Example 3: -----------
 * 
 * Input: nums = [0,0,0] 
 * Output: [[0,0,0]] 
 * Explanation: The only possible triplet sums up to 0.
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
		int[] intArr = { -1,0,1,2,-1,-4};//{-4,-1,-1,0,1,2}
//		int[] intArr = { 0,0,0,0};
		System.out.println(threeSum(intArr));
	}
	
	
	/**
	 * Approach
	 * 1. Sort the array (Sorting array is important to apply the two pointer algorithm)
	 * 2. Fix one number and apply the two pointer technique to the rest with the fixed number.
	 * 3. remove duplicates
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> numLists = new ArrayList<>();
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
			int fixNo = nums[i];
			int left = i+1;
			int right = nums.length -1;
			while(left < right) {
				int total = nums[left] + nums[right] + fixNo;
				if(total > 0) {
					--right;
				}
				else if(total < 0) {
					++left;
				}
				else {
					numLists.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// Skip duplicates for the left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Move both pointers
                    left++;
                    right--;
				}
			}
			++i;
		}
		return numLists;
	}
}
