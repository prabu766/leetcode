package com.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * Example 1: Input: ransomNote = "a", magazine = "b" Output: false
 * 
 * Example 2: Input: ransomNote = "aa", magazine = "ab" Output: false
 * 
 * Example 3: Input: ransomNote = "aa", magazine = "aab" Output: true
 * 
 * @param ransomNote
 * @param magazine
 * @return
 */
public class RansomNote {

	public static void main(String[] args) {
		
		System.out.println(canConstruct("aa", "ab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		Map<Character, Integer> ransomNoteCharMap = getCharCount(ransomNote);
		Map<Character, Integer> magazineCharMap = getCharCount(magazine);
		Iterator<Entry<Character, Integer>> itr = ransomNoteCharMap.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<Character, Integer> entry = itr.next();
			if ( magazineCharMap.get(entry.getKey())==null || entry.getValue() > magazineCharMap.get(entry.getKey())) {
				return false;
			}
		}
		return true;
	}

	private static Map<Character, Integer> getCharCount(String str) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (Character c : str.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0)+1);
		}
		return charMap;
	}

}
