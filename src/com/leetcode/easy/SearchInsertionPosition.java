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
		System.out.println(searchInsertOptimized(nums, 4));
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
	
	/**
	 * This approach is better than the above as it make half the data set in each loop.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsertOptimized(int[] nums, int target) {
		int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid + 1;
        }

        return start;
	}

}
