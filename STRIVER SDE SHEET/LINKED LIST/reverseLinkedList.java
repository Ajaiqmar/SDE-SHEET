// THE PROBLEM STATEMENT IS TO REVERSE THE GIVEN LINKED LIST.

// THE BRUTE FORCE APPROACH WOULD BE USE AN ARRAY TO REVERSE THE LINKED LIST.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// WE CAN OPTIMISE IT BY CARRYING OUT THE TASK AT HAND IN CONSTANT SPACE, THE INTUITION BEHIND IS, SINCE WE
// NEED TO ONLY CHANGE NEXT POINTER IN EACH NODE TO POINT TO THE PREVIOUS NODE, WE CAN DO IT IN THE FLY
// WHILE TRAVERSING IT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
/*
	Following is the structure of the Singly Linked List.
	class LinkedListNode<T>
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data)
        {
        	this.data = data;
    	}
	}

*/
public class Solution
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head)
    {
        if(head == null)
        {
            return head;
        }

        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> prev = null;

        while(temp.next != null)
        {
            LinkedListNode<Integer> curr = temp;
            temp = temp.next;
            curr.next = prev;
            prev = curr;
        }

        temp.next = prev;

        return temp;
    }
}
