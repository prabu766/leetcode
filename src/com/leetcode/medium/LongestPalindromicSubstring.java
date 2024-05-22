package com.leetcode.medium;


/**
 * 
 * Given a string s, return the longest palindromic substring  in s.

	Example 1:
	
	Input: s = "babad"
	Output: "bab"
	Explanation: "aba" is also a valid answer.
	Example 2:
	
	Input: s = "cbbd"
	Output: "bb"

 * @author prabhuddha.bhashitha
 *
 */
public class LongestPalindromicSubstring {

	
	public static void main(String[] args) {
		LongestPalindromicSubstring ll = new LongestPalindromicSubstring();
		String str = "ac";
		System.out.println(ll.longestPalindrome(str));
	}
	
	public String longestPalindrome(String str) {
		char[] charArr = str.toCharArray();
		int palindromeLength = 0;
		String longestPalindrome = "";
        for(int i=0;i<charArr.length;i++) {
        	for(int j =i;j< charArr.length;j++) {
        		if(charArr[i]==charArr[j]) {
        			boolean isPalindrome = isPalindrome(str,i,j+1);
        			if(isPalindrome && ((j-i) >= palindromeLength)) {
        				longestPalindrome = str.substring(i, j+1);
        				palindromeLength = j-i;
        			}
        		}
        	}
        }
        return longestPalindrome;
    }
	
	public boolean isPalindrome(String str,int start, int end) {
		String subStr = str.substring(start, end);
		char[] charArr = subStr.toCharArray();
		for(int j=0,k=charArr.length-1; k>=j;++j,--k) {
			if(charArr[j]!=charArr[k]) {
				return false;
			}
		}
		return true;
	}
}
