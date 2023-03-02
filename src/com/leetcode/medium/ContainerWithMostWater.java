package com.leetcode.medium;

/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {

		int[] intArr = {10,11,3,6,8};
		int maxArea = 0;
		int line1 = 0;
		int line2 = 0;
		int selectedHeight = 0;
		for(int i=0;i<intArr.length;i++) {
			for(int j=i+1;j<intArr.length;j++) {
				int height = Math.min(intArr[i] ,intArr[j]);
				int length = j-i;
				int area = height * length;
				if(area > maxArea) {
					System.out.println("height=" + height +" length="+length + " i=" + i +" j="+j + " area="+area);
					selectedHeight = height;
					maxArea = area;
					line1 =i;
					line2 =j;
				}
			}
		}
		System.out.println("Maximum area will is "+ maxArea + " and Lines will be "+ line1 +" and "+ line2 +" selectedHeight is "+ selectedHeight);
		
	}

}
