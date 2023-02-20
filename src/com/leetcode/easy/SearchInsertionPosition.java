package com.leetcode.easy;

/**
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,6], target = 5 Output: 2
 * 
 * Example 2: Input: nums = [1,3,5,6], target = 2 Output: 1
 * 
 * Example 3: Input: nums = [1,3,5,6], target = 7 Output: 4
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class SearchInsertionPosition {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 3));
	}

	public static int searchInsert(int[] nums, int target) {
		// if the target is greater than the array's max, return the next array index
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		int position = 0;
		if (target > nums[0]) {
			while (position < nums.length) {
				if (target == nums[position]) {
					return position;
				}
				if (target < nums[position + 1]) {
					return position + 1;
				}
				++position;
			}
		}
		return position;
	}
	
	public static int searchInsertOptimized(int[] nums, int target) {
		// if the target is greater than the array's max, return the next array index
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		if (target > nums[0]) {
			int start = 0;
			int end =nums.length;
			int position = start;
			
			while (position < end) {
				if (target == nums[position]) {
					return position;
				}
				if (target < nums[position + 1]) {
					return position + 1;
				}
				++position;
			}
		}
		return 0;
	}

}
