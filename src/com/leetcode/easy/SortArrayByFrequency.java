package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 *
 *Given an array of integers numbers, sort the array in increasing order based on the frequency of the values. 
 *If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 */
public class SortArrayByFrequency {

	public static void main(String[] args) {
		//int[] nums = {1,1,2,2,2,3};
		int[] nums = {-1,1,-6,4,5,-6,1,4,1};
		//nums = frequencySort(nums);
		nums = frequencySortMethod2(nums);
		Arrays.stream(nums).forEach(System.out::print);
	}

	public static int[] frequencySort(int[] nums) {
		Map<Integer,Integer> numCountMap = new HashMap<>();
		for(int num : nums) {
			numCountMap.put(num, numCountMap.getOrDefault(num, 0)+1);
		}
		
		Map<Integer,Integer> numCountTreeMap = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int res = numCountMap.get(o1).compareTo(numCountMap.get(o2));
				if(res ==0) {
					return o2.compareTo(o1);
				}
				return res;
			} 
		});
		numCountMap.entrySet().forEach(entry -> numCountTreeMap.put(entry.getKey(), entry.getValue()));
		
		int index =0;
		Iterator<Entry<Integer, Integer>> mapItr = numCountTreeMap.entrySet().iterator();
		while(mapItr.hasNext()) {
			Entry<Integer, Integer> entry = mapItr.next();
			int key = entry.getKey();
			int val = entry.getValue();
			for(int k =0; k< val;k++) {
				nums[index] = key;
				++index;
			}
		}
		
		return nums;
	}
	
	/**
	 * Optimized method without the TreeMap data structure
	 * @param nums
	 * @return
	 */
	public static int[] frequencySortMethod2(int[] nums) {
		Map<Integer,Integer> numCountMap = new HashMap<>();
		List<Integer> numsList = new ArrayList<>();
		
		for(int num : nums) {
			numsList.add(num);
			numCountMap.put(num, numCountMap.getOrDefault(num, 0)+1);
		}
		
		Collections.sort(numsList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int res = numCountMap.get(o1).compareTo(numCountMap.get(o2));
				if(res ==0) {
					return o2.compareTo(o1);
				}
				return res;
			} 
		});
		return numsList.stream().mapToInt(i -> i).toArray();
	}
}
