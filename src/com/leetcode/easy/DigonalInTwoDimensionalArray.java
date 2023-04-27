package com.leetcode.easy;

/**
 * Given 2D array calculate the sum of diagonal elements.
 * 
 * Example
 * 
 * myArray2D= {{1,2,3},{4,5,6},{7,8,9}};
 * 
 * sumDiagonalElements(myArray2D) # 15
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class DigonalInTwoDimensionalArray {

	public static void main(String[] args) {
		int[][] myArray2D = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(containsDuplicate(myArray2D));
	}

	public static int containsDuplicate(int[][] myArray2D) {

		int diagonal = 0;
		for (int i = 0; i < myArray2D.length; i++) {
			diagonal += myArray2D[i][i];
		}
		return diagonal;

	}
}
