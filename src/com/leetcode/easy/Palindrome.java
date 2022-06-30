package com.leetcode.easy;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		String word = "A man, a plan, a canal: Panama ";
		System.out.println(isPalindrome(word));
	}

	public static boolean isPalindrome(String word) {

		char[] charArray = word.toLowerCase().toCharArray();
		int firstIndex = 0;
		int lastIndex = charArray.length - 1;
		while (lastIndex >= firstIndex) {

			char firstChar = charArray[firstIndex];
			char lastChar = charArray[lastIndex];

			if (!Character.isLetterOrDigit(firstChar)) {
				++firstIndex;
				continue;
			}
			if (!Character.isLetterOrDigit(lastChar)) {
				--lastIndex;
				continue;
			}
			if (firstChar == lastChar) {
				--lastIndex;
				++firstIndex;
			} else {
				return false;
			}

		}
		return true;
	}
}
