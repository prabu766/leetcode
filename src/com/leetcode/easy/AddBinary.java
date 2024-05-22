package com.leetcode.easy;

/**
 * 
 * Given two binary strings a and b, return their sum as a binary string.
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 * @author prabhuddha.bhashitha
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		String a =      "1111";
		String b =      "1111";
		System.out.println(addBinary(a, b));
	}
	
	public static String addBinary(String a, String b) {
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
        StringBuilder sum = new StringBuilder();
        
        char carryForward = '0';
        int k = arr1.length;
        int j = arr2.length;
        
        while(true) {
        	char currentCarryForward= '0';
        	char one = k<=0 ? '0' : arr1[k-1];
        	char two = j<=0 ? '0' : arr2[j-1];
        	
        	if(k==0) {
        		one = carryForward;
        	}else if(j==0) {
        		two = carryForward;
        	}else if(carryForward =='1') {
        		if(one =='1') {
        			currentCarryForward = '1';
        			one = '0';
        		}else {
        			currentCarryForward = '0';
        			one = '1';
        		}
        	}
    		carryForward = add(one, two,sum);
    		if(currentCarryForward =='1') {
    			carryForward = currentCarryForward; 
    		}
        	System.out.println("k :" + k+ ", j :"+j + " one :" + one+ ", two :"+two + ", Sum :"+ sum.toString() +", carryForward :"+carryForward );
        	--k;
        	--j;
        	if(k<=0 && j<=0) {
        		if(carryForward =='1') {
        			sum.append(carryForward);
        		}
        		break;
        	}
        }
        return sum.reverse().toString();
    }
	
	public static char add(char x, char y, StringBuilder sum) {
		sum.append((x == y) ?  '0' : '1');
		return (x == '1' && y == '1') ? '1' : '0';
	}
	
}
