package com.leetcode.easy;


/**
 * 
 * @author prabhuddha.bhashitha
 *
 *
 *You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000

 */
public class MaximumAverageSubarray {
	
	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
//		int[] nums = {1,12,-5,-6};
//		int[] nums = {-1};
		int k = 4;
		System.out.println(findMaxAverage(nums, k));

	}
	
	/**
	 * Used sliding window technique
	 * @param nums
	 * @param k
	 * @return
	 */
	public static double findMaxAverage(int[] nums, int k) {
        double maxAve = 0;
        double sum = 0;
        for(int i=0;i<nums.length;i++) {
        	if((i+k) > nums.length) {
        		break;
        	}
        	if(i==0) {
        		int j=0;
        		while(j<(i+k)) {
            		sum += nums[j];
            		++j;
            	}
        	}else {
        		sum = sum - nums[i-1] + nums[i+k-1];
        	}
        	if(maxAve==0) {
        		maxAve = sum/k;
        	}else {
        		maxAve = Math.max(maxAve, sum/k);
        	}
        }
        return maxAve;
    }

}
