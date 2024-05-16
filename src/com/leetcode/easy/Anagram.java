package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 * @author prabhuddha.bhashitha
 *
 */
public class Anagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("aacc", "ccac"));
		System.out.println(isAnagram("anagram", "anagram"));
		System.out.println(isAnagram("rat", "car"));
	}
	
	public static boolean isAnagram(String s, String t) {
        int strLength = s.length();
        if(strLength==t.length()){
        	List<String> listOne = new ArrayList(Arrays.asList(s.split("")));
        	for(char k : t.toCharArray()) {
        		if(listOne.contains(String.valueOf(k))){
        			listOne.remove(String.valueOf(k));
        			System.out.println(listOne);
        		}else {
        			return false;
        		}
        	}
        	return listOne.isEmpty();
        }
        return false;
	}
	
}

