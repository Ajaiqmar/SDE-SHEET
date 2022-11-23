// THE PROBLEM STATEMENT IS TO FIND THE MIDDLE NODE OF A LINKED LIST.

// THE BRUTE FORCE APPROACH WOULD BE TO TRAVERSE THE LINKED LIST TWICE TO FIND THE
// MIDDLE NODE OF A LINKED LIST. FIRST, WE FIND THE TOTAL NUMBER OF NODES IN THE
// LINKED LIST DURING FIRST PASS, THEN, WE FIND MIDDLE NODE OF A LINKED LIST ON
// THE SECOND PASS.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE IT FURTHER TO ACHIEVE THE TASK AT HAND IN ONE PASS.
// WELL, WE CAN USE TORTOISE AND HARE TECHNIQUE TO
// FIND THE MIDDLE NODE OF A LINKED LIST.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
/****************************************************************

    Following is the class structure of the Node class:

       class Node
        {
        public:
            int data;
            Node next;
            Node(int data)
            {
              this.data = data;
              this.next = null;
            }
        };

*****************************************************************/

public class Solution {
    public static Node findMiddle(Node head)
    {
        Node slow = head,fast = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
