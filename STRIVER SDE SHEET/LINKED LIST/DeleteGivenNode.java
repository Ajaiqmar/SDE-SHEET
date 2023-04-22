// THE PROBLEM STATEMENT IS TO REMOVE THE GIVEN NODE. ( NOTE : ONLY THE NODE TO BE DELETED WILL BE GIVEN AND IT WOULDN'T BE THE LAST
// NODE). NEED TO ACHIEVE THE TASK IN O(1) TIME COMPLEXITY.

// WE CAN STRAIGHT AWAY JUMP TO THE OPTIMISED APPROACH AS IT CAN BE REGARDED AS THE BRUTE FORCE APPROACH AS WELL.
// IT IS TO COPY THE NEXT VALUE NODE ONTO THIS ONE AND THEN DELETE THE NEXT NODE.
// REASON BEING WHY IS LINKED LIST HAS ONE WAY TO TRAVERSE THE LINKED LIST AND CAN BE INDEXED, SO WE NEED TO KNOW THE PREVIOUS NODE TO DELETE 
// THE CURRENT ONE.

// TIME COMPLEXITY : O(1)
// SPACE COMPLEXITY : O(1)

import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) 
  {
		node.data = node.next.data;
        node.next = node.next.next;
	}
}
