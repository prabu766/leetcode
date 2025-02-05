package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/4sum/description/
 * 
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

 * @author prabhuddha.bhashitha
 *
 */
public class FourSum {
	
	public static void main(String[] args) {
//		int[] intArr = { 1,0,-1,0,-2,2};
//		int[] intArr = { -2,-1,-1,1,1,2,2};
		int[] intArr = {2,2,2,2,2};//
//		int[] intArr = { -3,-2,-1,0,0,1,2,3};
//		int[] intArr = {1000000000,1000000000,1000000000,1000000000};
//		int[] intArr = { 0,0,0,0};
		int target = 8;
		System.out.println(fourSum(intArr,target));
	}
	
	
	/**
	 * Approach
	 * 1. Sort the array (Sorting array is important to apply the two pointer algorithm)
	 * 2. Fix one number and apply the two pointer technique to the rest with the fixed number.
	 * 3. remove duplicates
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> numLists = new ArrayList<>();
		
		Arrays.sort(nums);
		 for(int i=0;i<nums.length -3;++i) {
			int outerFix = nums[i];
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			for(int j = i+1;j<= nums.length -2;++j ) {
				if(j>i+1 && nums[j]==nums[j-1]) {
					continue;
				}
				int innerFix = nums[j];
				int left=j+1;
				int right=nums.length-1;
				while(left<right) {
					long sum =  (long)nums[left]+nums[right]+outerFix+innerFix;
					if(sum >target) {
						--right;
					}else if(sum <target) {
						++left;
					}else {
						List<Integer> l =Arrays.asList(outerFix,innerFix,nums[left],nums[right]);
						//if(!numLists.contains(l)) {
							numLists.add(l);
						//}
						while(left < right && nums[left]==nums[left+1]) {
							++left;
						}
						while(left < right && nums[right]==nums[right-1]) {
							--right;
						}
						left++;
	                    right--;
					}
				}
			}
		}
		return numLists;
	}

}
