package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums of length n where all the integers of nums are in
 * the range [1, n] and each integer appears once or twice, return an array of
 * all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant
 * extra space.
 * 
 * 
 * Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:

Input: nums = [1]
Output: []

 * @author prabhuddha.bhashitha
 *
 */
public class FindAllDuplicatesInAnArray {

	public static void main(String[] args) {
		int[] numbers = new int[]{1,1,2};
		System.out.println(findDuplicates(numbers));
	}
	
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();
		Map<Integer,Integer> countMap = new HashMap<>(duplicates.size());
		for(int i: nums) {
			if(countMap.put(i, 1)!=null) {//not null means there was same number in the map so it is a duplicate
				duplicates.add(i);
			}
		}
		return duplicates;
    }
}
