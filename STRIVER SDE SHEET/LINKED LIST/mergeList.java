// THE PROBLEM STATEMENT IS TO MERGE THE GIVEN SORTED LINKED LISTS.

// THE BRUTE FORCE APPROACH IS TO SET THE NEXT POINTER OF THE LAST NODE IN THE FIRST LINKED LIST TO POINT
// TO THE HEAD OF THE SECOND LINKED LIST. THEN, SORT THE NEW LINKED LIST.
// TIME COMPLEXITY : O(N*LOG N)
// SPACE COMPLEXITY : O(N)

// SINCE, THE GIVEN LINKED LIST IS SORTED, WE CAN USE THAT TO OPTIMISE THE CODE TO CARRY OUT
// THE TASK AT HAND IN LINEAR TIME, THE INTUITION BEHIND THE APPROACH IS, SINCE WE KNOW THAT THE LINKED LIST ARE
// SORTED, THE HEAD POINTERS OF BOTH THE LINKED LIST WILL BE POINTING TO THE LOWEST DATA VALUE POINTER, SO
// WE JUST NEED TO COMPARE BOTH OF THEM TO FIND THE LOWEST AMAONG THEM
// THEN TAKE THAT POINTER AND ADD IT TO THE LINKED LIST, THEN MOVE THE POINTER TO THE NEXT NODE.
// TIME COMPLEXITY : O(N+M)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;

/************************************************************

    Following is the linked list node structure:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution
{
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second)
    {
		    LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        while(first != null && second != null)
        {
            if(first.data <= second.data)
            {
                if(head == null)
                {
                    head = first;
                    tail = head;
                    first = first.next;

                    head.next = null;
                }
                else
                {
                    tail.next = first;
                    first = first.next;
                    tail = tail.next;
                    tail.next = null;
                }
            }
            else
            {
                if(head == null)
                {
                    head = second;
                    tail = head;
                    second = second.next;

                    head.next = null;
                }
                else
                {
                    tail.next = second;
                    second = second.next;
                    tail = tail.next;
                    tail.next = null;
                }
            }
        }

        while(first != null)
        {
            if(head == null)
            {
                head = first;
                tail = head;
                first = first.next;

                head.next = null;
            }
            else
            {
                tail.next = first;
                first = first.next;
                tail = tail.next;
                tail.next = null;
            }
        }

        while(second != null)
        {
            if(head == null)
            {
                head = second;
                tail = head;
                second = second.next;

                head.next = null;
            }
            else
            {
                tail.next = second;
                second = second.next;
                tail = tail.next;
                tail.next = null;
            }
        }

        return head;
	}
}
