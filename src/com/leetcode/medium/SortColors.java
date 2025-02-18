package com.leetcode.medium;

/**
 * Given an array nums with n objects colored red, white, or blue, 
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 * @author prabhuddha.bhashitha
 *
 */
public class SortColors {
	
	public static void main(String[] args) {
//		int[] nums = {2,0,2,1,1,0};
		int[] nums = {2,0,1};
		int[] sortedArr = sortColors(nums);
		for(int value : sortedArr) {
			System.out.print(value);
		}
		
	}
	
	public static int[] sortColors(int[] nums) {
		for(int k=0;k<nums.length -1;k++) {
			for(int i= nums.length -1 ; i>0; --i) {
				if(nums[i] < nums[i-1]) {
					int temp = nums[i-1];
					nums[i-1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		return nums;
    }

}
