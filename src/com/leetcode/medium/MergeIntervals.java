package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 * @author prabhuddha.bhashitha
 *
 */
public class MergeIntervals {
	
	public static void main(String[] args) {
//		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//		int[][] intervals = {{1,4},{4,5}};
//		int[][] intervals = {{1,4},{2,3}};
		int[][] intervals = {{1,3},{3,6}};
		intervals = merge(intervals);
		for(int[] interval: intervals) {
			System.out.println("\n");
			for(int val: interval) {
				System.out.println(val);
			}
		}
	}
	
	/**
	 * Logic
	 * 1. Sort two dimensional array. Because we need to compare the last digit of each interval
	 * 2. Go one 
	 * @param intervals
	 * @return
	 */
	public static int[][] merge(int[][] intervals) {
		//sort from the first number for ascending order
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		List<int[]> merged = new ArrayList<>();
		
		for( int[] interval : intervals) {
			if(merged.isEmpty() || interval[0] > merged.get(merged.size()-1)[1]) {
				merged.add(interval);
			}else if(interval[0] <= merged.get(merged.size()-1)[1]) {
				if(interval[1] > merged.get(merged.size()-1)[1]) {
					merged.get(merged.size()-1)[1] = interval[1];
				}
			}
		}
		return merged.toArray(new int[merged.size()][]);
    }

}
