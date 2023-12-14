package com.leetcode.easy;

/**
 * Calculate a power of given number
 * @author prabhuddha.bhashitha
 *
 */
public class PowerOfNumber {
	
	public static void main(String[] args) {
		System.out.println(powerOf(10,3));
	}
	
	public static int powerOf(int number, int power) {
		if(power==1) {
			return number;
		}
		return number * powerOf(number, power-1);
	}

}
