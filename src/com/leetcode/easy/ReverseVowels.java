package com.leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * Given a string s, reverse only all the vowels in the string and return it.
 * 
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
 * and upper cases, more than once.
 * 
 * Example 1:
 * 
 * Input: s = "hello" Output: "holle" Example 2:
 * 
 * Input: s = "leetcode" Output: "leotcede"
 * 
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class ReverseVowels {

	static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U');

	public static void main(String[] args) {
		String input = "hello";
		//String input = "leetcode";
		//String input = "PrbaeioU";
		System.out.println(reverseVowels(input));
	}

	public static String reverseVowels(String s) {
		char[] charArr = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		char temp = ' ';
		while (i < j) {
			if(charArr[i] == charArr[j]) {
				++i;
				--j;
				continue;
			}
			if (vowels.contains(charArr[i])) {
				while (j > i) {
					if (vowels.contains(charArr[j])) {
						temp = charArr[j];
						charArr[j] = charArr[i];
						charArr[i] = temp;
						--j;
						break;
					}
					--j;
				}
			}
			++i;
		}
		return String.valueOf(charArr);

	}

}
