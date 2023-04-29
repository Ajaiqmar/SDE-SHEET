// THE PROBLEM STATEMENT IS TO CHECK IF THE GIVEN LINKED LIST IS PALINDROME OR NOT.

// THE BRUTE FORCE APPROACH WOULD BE TO USE EITHER RECURSION OR ADDITIONAL DATA STRUCTURE TO STORE THE FIRST
// HALF OR THE SECOND ONE TO CROSS CHECK WITH THE OTHER.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// BUT CAN WE DO BETTER?? WELL, YES WE CAN REMOVE THE O(N) ADDITIONAL SPACE BY REVERSING EITHER THE FIRST OR
// THE SECOND HALF, THEN CROSSCHECKING IT WITH THE OTHER.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*; 

/****************************************************************
    Struture of Linked List
    
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}
*****************************************************************/

public class Solution {

	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
	{
		LinkedListNode<Integer> newHead = null;
		LinkedListNode<Integer> newTail = null;

		while(head != null)
		{
			if(newHead == null)
			{
				newHead = head;
				head = head.next;
				newTail = newHead;
				newTail.next = null;
			}
			else
			{
				LinkedListNode<Integer> temp = head;
				head = head.next;
				temp.next = newHead;
				newHead = temp;
			}
		}

		return newHead;
	}

	public static boolean isPalindrome(LinkedListNode<Integer> head) 
	{
		LinkedListNode<Integer> fast = head;
		LinkedListNode<Integer> slow = head;

		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}

		if(fast != null)
		{
			slow = slow.next;
		}

		LinkedListNode<Integer> temp = head;
		LinkedListNode<Integer> nTemp = reverse(slow);

		while(nTemp != null)
		{
			if(temp.data.compareTo(nTemp.data) != 0)
			{
				return false;
			}

			temp = temp.next;
			nTemp = nTemp.next;
		}

		return true;
	}
}