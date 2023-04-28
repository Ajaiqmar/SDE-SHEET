// THE PROBLEM STATEMENT IS CHECK WHETHER THE GIVEN LINKEDLIST IS CYCLIC OR NOT. MEANING THE LINKEDLIST DOESN'T REACH THE END AND KEEPS ON LOOPING.

// THE BRUTE FORCE APPROACH WOULD BE TO TRAVERSE THE LINKED LIST AND STORE EACH NODE IN A HASHTABLE / HASHMAP, THEN CHECK IF THE NODE
// WHICH HAS ALREADY BEEN VISITED POPS UP AGAIN, IF SO THEN THERE IS A CYCLE.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// NOW, THE INTERVIEWER MIGHT BE SATISFIED BUT NOT IMPRESSED, BECAUSE THERE IS A O(N) SPACE COMPLEXITY, NOW CAN WE REDUCE IT SOMEHOW,
// YEP, WE CAN USE THE TORTOISE AND HARE TECHNIQUE, WHAT HAPPENS IN THIS APPROACH IS, WE WILL HAVE TWO TEMPORARY VARIABLES AND TRAVERSE THE 
// LINKEDLIST, ONE WILL MOVE AT A PACE OF ONE NODE AND OTHER WILL MOVE AT A PACE OF TWO, NOW IF THERE IS A CYCLE THEN THEY ARE BOUND TO MEET,
// ELSE THEY WILL REACH THE END ON THE LINKED LIST.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*; 
/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution 
{
    public static boolean detectCycle(Node<Integer> head) 
    {
        if(head == null || head.next == null)
        {
            return false;
        }

        Node<Integer> fast = head.next.next;
        Node<Integer> slow = head.next;

        while(fast != slow)
        {
            if(fast == null || fast.next == null)
            {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
