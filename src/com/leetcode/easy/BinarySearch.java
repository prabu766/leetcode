package com.leetcode.easy;
/**
 * 
 * 
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
 * If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

 * @author prabhuddha.bhashitha
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 20;
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums, int target) {
       int min = 0;
       int max = nums.length -1;
       
       while(min<=max) {
    	   int midIndex = (min + max)/2;
    	   if(nums[midIndex] == target) {
    		   return midIndex;
    	   }else if(target > nums[midIndex] ) {
    		   min = midIndex +1;
    	   }else {
    		   max = midIndex -1;
    	   }
       }
       return -1;
    }

}
