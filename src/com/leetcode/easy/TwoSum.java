package com.leetcode.easy;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] numbersArr = new int[] { -2, 7, 11, 15 };
		int target = 13;
		numbersArr = twoSum(numbersArr, target);
		for (int num : numbersArr) {
			System.out.print(num + " ");
		}

	}

	public static int[] twoSum(int[] nums, int target) {
		int val1Index = -1;
		int val2Index = -1;
		String val2LessThanTarget = null;

		outer: for (int i = 0; i < nums.length; i++) {

			int val1Int = nums[i];
			if (val1Int <= target || (val2LessThanTarget != null && Integer.parseInt(val2LessThanTarget) < 0)
					|| target < 0) {
				int remainder = target - val1Int;

				for (int k = i + 1; k < nums.length; k++) {
					int val2Int = nums[k];
					if (val2Int <= remainder || val1Int < 0) {
						val2LessThanTarget = String.valueOf(val2Int);
						if ((val1Int + val2Int) == target) {
							val1Index = i;
							val2Index = k;
							break outer;
						}
					}
				}
			}
		}
		if (val1Index != -1 && val2Index != -1) {
			return new int[] { val1Index, val2Index };
		}

		return null;
	}

}
