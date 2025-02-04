package com.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Leetcode link : https://leetcode.com/problems/boats-to-save-people/description/
 * @author prabhuddha.bhashitha
 * 
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. 
 * Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 * 
 *
 */
public class BoatsToSavePeople {
	
	public static void main(String[] args) {
		int[] people = {3,5,3,4};
//		int[] people = {3,2,2,1};
//		int[] people = {3,8,7,1,4};
//		int[] people = {1,2};
//		int[] people = {2,2};
//		int[] people = {3,5,3,4};
//		int[] people = {3,2,3,2,2};
//		int[] people = {3,8,4,9,2,2,7,1,6,10,6,7,1,7,7,6,4,4,10,1};
		int limit = 5;
		System.out.println(numRescueBoatsTwoPointerTechnique(people,limit));
	}
	
	
	/**
	 * Approach
	 * 1. Sort the array (Sorting array is important to apply the two pointer algorithm)
	 * 2. Fix one number and apply the two pointer technique to the rest with the fixed number.
	 * 3. remove duplicates
	 * @param nums
	 * @return
	 */
	public static int numRescueBoatsBruteForce(int[] people, int limit) {
		int boats =0;
		
		for(int i=0;i<people.length;++i) {
			if(people[i] > limit || people[i] ==-1) {
				continue;
			}
			int k =-1;
			//find the exact limit match or maximum match
			int gap = Integer.MAX_VALUE;
			for(int j=i+1;j<people.length;++j) {
				if(people[j] < 0) {
					continue;
				}
				if(people[j] >=limit) {
					people[j] = -1;	
					continue;
				}
				int weight = people[i] + people[j]; 
				if(weight==limit) {
					k = j;
					break;
				}else if(weight < limit) {
					if(limit-weight < gap) {
						gap = limit-weight;
						k = j;
					}
				}
			}
			people[i]=-1;
			if(k!=-1) {
				people[k]=-1;
			}
			++boats;
		}
		return boats;
	}
	
	
	/**
	 * This method uses the two pointer technique
	 * @param people
	 * @param limit
	 * @return
	 */
	 public static int numRescueBoatsTwoPointerTechnique(int[] people, int limit) {
	        int boatCount = 0;
	        Arrays.sort(people);
	        
	        int left = 0;
	        int right = people.length - 1;
	        
	        while(left <= right){
	            int sum = people[left] + people[right];
	            if(sum <= limit){// if the lightest person can go with the heaviest person, that is the best combination.
	                boatCount++;
	                //move both pointers to mark two people sent in this boat
	                left++;
	                right--;
	            }
	            else{//if the sum is greater than limit, it means that there is no one in this group who can go with current heaviest person so he has to go alone. 
	            	//So increment the boat count and move only the right pointer
	                boatCount++;
	                right--;
	            }
	            System.out.println("sum :"+ sum+ " , boat count :"+boatCount);
	        }
	        return boatCount;
	    }
	

}
