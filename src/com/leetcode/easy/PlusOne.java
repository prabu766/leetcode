package com.leetcode.easy;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * 
 * Example 1:

	Input: digits = [1,2,3]
	Output: [1,2,4]
	Explanation: The array represents the integer 123.
	Incrementing by one gives 123 + 1 = 124.
	Thus, the result should be [1,2,4].
	
  Example 2:

	Input: digits = [4,3,2,1]
	Output: [4,3,2,2]
	Explanation: The array represents the integer 4321.
	Incrementing by one gives 4321 + 1 = 4322.
	Thus, the result should be [4,3,2,2].
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class PlusOne {
	
	public static void main(String[] args) {
		
		int[] resultArr = new int[]{9};
		resultArr = plusOne(resultArr);
		for(int a : resultArr) {
			System.out.print(a);
		}
	}
	
	public static int[] plusOne(int[] digits) {
        int remainder =0;
        for(int index= digits.length-1;index >=0;--index) {
        	int digit = digits[index];
        	if(remainder >0 || (index == (digits.length-1))) {
        		if(index == (digits.length-1)){
        			++digit;
        		}
        		digit += remainder;
        		if(digit==10) {
        			remainder = 1;
        			digit =0;
        		}else {
        			remainder = 0;
        		}
        	}
        	digits[index] =digit;
        }
        if(remainder ==1) {
        	int[] resultArr = Arrays.copyOf(digits, digits.length+1);
        	resultArr[0]=1;
        	return resultArr;
        }
        return digits;
    }
}
