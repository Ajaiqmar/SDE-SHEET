// THE PROBLEM STATEMENT IS TO FIND THE NODE VALUE AT WHICH THE BOTH THE LINKED LIST MERGES, IF THERE IS NO INTERSECTION
// THEN RETURN -1.

// THE BRUTE FORCE APPROACH WOULD BE TO TAKE A NODE IN EITHER OF THE ONE LINKED LIST AND TRAVERSE THE OTHER TO CHECK IF IT IS PRESENT
// IN THE OTHER.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// THE INTUITION BEHIND THE OPTIMISED APPROACH WOULD BE, SINCE THE LENGTH OF BOTH LINKED LIST ONLY VARIES BEFORE THE POINT
// OF INTERSECTION, WE NEED TO MAKE SURE THAT DIFFERNCE IS REDUCED, BY DOING SO, WE CAN MOVE TO THE POINT OF INTERSECTION AT THE SAME PACE.
// SO, EITHER FIND THE LENGTH OF EACH OF THE LINKED LIST, AND TRAVERSE THE BIGGER LINKEDLIST UNTIL 
// THE LENGTH IS SAME. THEN, TRAVERSE BOTH OF THEM TO FIND THE POINT OF INTERSECTION. OR YOU CAN DO THE SAME THING IN A MORE
// AESTHETICALLY PLEASING WAY TO THE INTERVIEWER LIKE BELOW.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)



import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution 
{
	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) 
	{
		LinkedListNode<Integer> tempA = firstHead;
		LinkedListNode<Integer> tempB = secondHead;

		while(tempA != tempB)
		{
			tempA = ((tempA == null) ? secondHead : tempA.next);
			tempB = ((tempB == null) ? firstHead : tempB.next);
		}

		if(tempA == null)
		{
			return -1;
		}

		return tempA.data;
	}
}
