// THE PROBLEM STATEMENT IS TO REMOVE THE N-TH NODE FROM BACK OF THE LINKED LIST.

// THE BRUTE FORCE APPROACH WOULD BE TO FIND THE LENGTH OF THE LINKED LIST FIRSTLY,
// THEN AGAIN TRAVERSE THE LINKED LIST TO FIND THE K-TH NODE OF THE LINKED LIST FROM THE BACK AND REMOVE IT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// WE CAN OPTIMISE IT FURTHER BY CARRYING OUT THE TASK AT HAND IN ONE PASS. FOR THAT,
// WE USE TWO - POINTER APPROACH WHERE A POINTER WILL BE TRAVERSED FOR K NODES FIRST, THEN WE USE ANOTHER POINTER
// TO POINT TO THE HEAD, THEN WE MOVE BOTH THE POINTERS AT THE SAME PACE, WHICH WILL HELP US TO PINPOINT
// THE K-TH NODE FROM BACK OF THE LINKED LIST.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
/****************************************************************

	Following is the structure of the Singly Linked List.

	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution
{
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K)
    {
        if(head == null || K == 0)
        {
            return head;
        }

		LinkedListNode<Integer> temp = head;

        while(K > 0)
        {
            temp = temp.next;
            K -= 1;
        }

        LinkedListNode<Integer> t = head,prev = null;

        while(temp != null)
        {
            temp = temp.next;
            prev = t;
            t = t.next;
        }

        if(prev != null)
        {
            prev.next = t.next;
        }
        else
        {
            head = head.next;
        }

        return head;
	}
}
