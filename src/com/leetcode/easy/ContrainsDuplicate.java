package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class ContrainsDuplicate {

	public static void main(String[] args) {
		int[] intArr = {2,11,3,6,2};
		System.out.println(containsDuplicate(intArr));
	}
	public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i : nums){
        	if(countMap.putIfAbsent(i, 1)!=null) {
        		return true;
        	}
        }
        return false;
    }
}
