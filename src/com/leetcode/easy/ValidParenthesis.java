package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * 
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class ValidParenthesis {

	private static Map<Character, Character> parenthesisPairMap = new HashMap<>();
	static {
		parenthesisPairMap.put('(', ')');
		parenthesisPairMap.put('{', '}');
		parenthesisPairMap.put('[', ']');
	}

	public static void main(String[] args) {
		//String str = "(])";
		String str = "[()]{}";
		//String str = "(])";
		System.out.println(isValid(str));
	}

	public static boolean isValid(String s) {
		Stack<Character> parenthesisStack = new Stack<>();
		char[] charArr = s.toCharArray();
		for (Character parenthesis : charArr) {
			if (parenthesisPairMap.containsKey(parenthesis)) {// means this is an opening parenthesis
				parenthesisStack.push(parenthesis);
			} else if (!parenthesisStack.isEmpty()) {
				Character topChar = parenthesisStack.peek();
				if (parenthesis.equals(parenthesisPairMap.get(topChar))) {
					parenthesisStack.pop();
				}else {
					return false;
				}
			} else {
				return false;
			}
		}
		return parenthesisStack.isEmpty();
	}
}
