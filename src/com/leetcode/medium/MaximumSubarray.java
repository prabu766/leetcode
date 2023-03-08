package com.leetcode.medium;

/**
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray
 * [4,-1,2,1] has the largest sum 6.
 * 
 * Example 2: Input: nums = [1] Output: 1 Explanation: The subarray [1] has the
 * largest sum 1.
 * 
 * Example 3: Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray
 * [5,4,-1,7,8] has the largest sum 23.
 * 
 * @author prabhuddha.bhashitha
 *
 */

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] intArr = { -2,1,-3,4,-1,2,1,-5,4 };
		// int[] intArr = { 5,4,-1,7,8 };
		//int[] intArr = { 1 };
		// int[] intArr = { -2, 1 };
		System.out.println(maxSubArrayKadanesAlgo(intArr));
		//System.out.println(maxSubArrayBruteForce(intArr));
	}

	/**
	 * This method has written kadane's algorithm Kadane's algorithm ->
	 * 
	 * Maximum value of addition till an index of an array is equal to the value in
	 * that index or addition of previous sum and that index's value. 
	 * 
	 * local_sum[i] =
	 * Math.max( nums[i], nums[i] + local_sum[i-1])
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxSubArrayKadanesAlgo(int[] nums) {
		int globalMax = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum = Math.max(nums[i], nums[i] + sum);
			if (sum > globalMax) {
				globalMax = sum;
			}
		}

		return globalMax;
	}

	public static int maxSubArrayBruteForce(int[] nums) {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			while (j < nums.length) {
				int k = i;
				int subArrayTotal = 0;
				while (k <= j) {
					subArrayTotal += nums[k];
					++k;
				}
				max = Math.max(max, subArrayTotal);
				++j;
			}
		}
		return max;
	}
}
