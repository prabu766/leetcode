package com.leetcode.easy;

/**
 * Reverse string without changing position of special characters
 * @author prabhuddha.bhashitha
 *
 */
public class ReverseStringWithSpecialCharacter {
	
	public static void main(String[] args) {
		reverseString(new char[] {'P','r','a','-','u','d','d','h','a'});
	}
	
	public static void reverseString(char[] s) {
        char temp;
        int j = s.length -1;
        for(int i=0;i<s.length;i++){
        	if(!Character.isAlphabetic((s[i])) || !Character.isAlphabetic((s[j]))) {
        		continue;
        	}
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
