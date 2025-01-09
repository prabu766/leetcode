package com.leetcode.easy;

/**
 * 
 * @author prabhuddha.bhashitha
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
	If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

 */
public class MiddleOfLinkedList {

	//13 -> 17 -> 90 -> 76 -> 45 -> 32 -> 10 -> NULL
	public static void main(String argvs[])  
	{  
		ListNode h = new ListNode(1);  
		h.next = new ListNode(2);  
		h.next.next = new ListNode(3);  
		h.next.next.next = new ListNode(4);  
		h.next.next.next.next = new ListNode(5);  
		h.next.next.next.next.next = new ListNode(6);  
		MiddleOfLinkedList obj = new MiddleOfLinkedList();  
		System.out.println(obj.middleNodeOptimized(h).val);  
	}  
	
	/**
	 * This method use the concept of doubling the slow pointer and use it as the fast pointer.
	 * There is not the optimized method as 2 loops involved in every iteration.
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		ListNode middleNode = head;
		int slow= 0;
		int fast = 0;
		ListNode tempNode = head;
		//loop till next node is null. then that is the end of lined list. and slow pointer is in the middle
		int k =0;
		while(tempNode!=null) {
			++slow;
			fast = slow * 2;
			if(slow!=1) {
				middleNode = middleNode.next;
			}
			k=0;
			while(k < fast && tempNode!=null) {
				if(k==0) {
					tempNode = head; 
				}else {
					tempNode = tempNode.next;
				}
				++k;
			}
			System.out.println("slow :"+ slow + ", fast :"+ fast+", middleNode = "+middleNode.val+", k="+k);
		}
		return middleNode;
    }
	
	/**
	 * This solution is based on the concept that "when slow pointer moves 1, fast pointer moves 2"
	 * @param head
	 * @return
	 */
	public ListNode middleNodeOptimized(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		//fast null or fast.next null means that we have come to the last of linked list
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	
	static class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
}
