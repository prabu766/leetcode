package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits. Repeat the process until the number equals 1 (where it will stay), or
 * it loops endlessly in a cycle which does not include 1. Those numbers for
 * which this process ends in 1 are happy. Return true if n is a happy number,
 * and false if not.
 * 
 * Example : Input: n = 19 Output: true Explanation: 
 * 1*1 + 9*9 = 82 
 * 8*8 + 2*2 = 68 
 * 6*6 + 8*8 = 100 
 * 1*1 + 0*0 + 0*0 = 1
 * 
 * So 19 is a happy number
 * @author prabhuddha.bhashitha
 * 
 * Logic:
 * 1. Get the square of remainder of n by 10 (modulo operation) and add to the sum
 * 2. set the new number to the divider
 * Continue above two steps until n >0
 * 
 * Repeat the same steps to considering sum as the new n. 
 * 
 * The trick here to identify, some numbers will have an infinite loop. HashSet is used here for that. 
 * In above steps, if we found a number which was in a previous step, that means this will go to a loop and it'll never return true.
 *
 */
public class HappyNumber {

	private Set<Integer> numberSet = new HashSet<>();
	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(116));
	}
	public boolean isHappy(int n) {
		int sum = getNext(n);
		if(numberSet.contains(sum)) {
			return false;
		}
		numberSet.add(sum);
		return sum ==0 ? false : (sum ==1 ? true : isHappy(sum));
	}
	
	public static int getNext(int n) {
		int sum =0;
		while(n > 0) {
			int remainder = n%10;
			sum += (remainder * remainder);
			n = n/10;
		}
		return sum;
	}
	
	

}
