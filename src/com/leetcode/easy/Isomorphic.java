package com.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 *
 *Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

 
Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true
 */
public class Isomorphic {
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg","add"));
		System.out.println(isIsomorphic("foo","bar"));
		System.out.println(isIsomorphic("paper","title"));
	}
	
	public static boolean isIsomorphic(String s, String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		Map<Character,String> sMap = getCharListMap(s);
		Map<Character,String> tMap = getCharListMap(t);
		for(String sVal : sMap.values()) {
			Iterator<Character> tIter = tMap.keySet().iterator();
			while(tIter.hasNext()) {
				char tChar = tIter.next();
				if(tMap.get(tChar).equals(sVal)) {
					tIter.remove();	
				}
			}
		}
		if(tMap.size()>0) {
			return false;
		}
		return true;
    }
	
	private static Map<Character,String> getCharListMap(String str){
		Map<Character,String> charIndexMap = new HashMap<>();
		for(int index = 0; index < str.length(); index++) {
			char stringChar = str.charAt(index);
			charIndexMap.put(stringChar, charIndexMap.getOrDefault(stringChar, "") +index);
		}
		return charIndexMap;
	}

}
