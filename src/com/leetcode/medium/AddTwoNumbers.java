package com.leetcode.medium;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode returnNode = null;
		int carryForward = 0;
		ListNode currentNode = null;
		while (l1 != null || l2 != null) {
			int sum = carryForward;
			if (l2 != null) {
				sum += l2.val;
			}
			if (l1 != null) {
				sum += l1.val;
			}
			if (sum >= 10) {
				carryForward = 1;
				sum = sum - 10;
			} else {
				carryForward = 0;
			}

			ListNode rtNode = new ListNode(sum);
			if (returnNode == null) {
				returnNode = rtNode;
				currentNode = returnNode;
			} else if (currentNode != null) {
				currentNode.next = rtNode;
				currentNode = currentNode.next;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carryForward > 0) {
			currentNode.next = new ListNode(carryForward);
		}
		return returnNode;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
