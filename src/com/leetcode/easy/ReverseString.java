package com.leetcode.easy;

/**
 * 
 * @author prabhuddha.bhashitha
 * 
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:

 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:

 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		reverseString(new char[] {'P','r','a','b','u','d','d','h','a'});
		reverseString(new char[] {'C','h','a','m','i','n','i'});
	}
	
	public static void reverseString(char[] s) {
        char temp;
        int j = s.length -1;
        for(int i=0;i<s.length;i++){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            --j;
            if(i >= j){
                break;
            }
        }
        System.out.println(s);
    }
	
}
