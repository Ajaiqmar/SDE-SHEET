// THE PROBLEM STATEMENT IS TO ADD TWO NUMBERS WHICH IS REPRESENTED AS LINKED LIST IN THE REVERSE ORDER AND THERE ARE NO
// LEADING ZEROS.

// THE APPROACH THAT I WENT WITH IS TO TRAVERSE AND ADD EACH DIGIT AND MAINTAIN A CARRYOVER COUNTER WHILE DOING SO 
// AND STORE THOSE VALUES IN A NEW LINKED LIST.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// ONE CAN ARGUE SAYING THAT SPACE COMPLEXITY WOULD HAVE BEEN O(1), WE CAN USE THE LINKEDLIST THAT WE HAVE BEEN PROVIDED
// RATHER THAN CREATING A NEW ONE, I JUST WENT WITH THE LATTER ONE BECAUSE WHAT IF THE LINKEDLIST PROVIDED IS TO
// BE USED AGAIN. 

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) 
    {
        int carryOver = 0;
        LinkedListNode head = null;
        LinkedListNode tail = null;

        while(head1 != null && head2 != null)
        {
            if(head == null)
            {
                head = new LinkedListNode((head1.data+head2.data+carryOver)%10);
                tail = head;
                carryOver = (head1.data+head2.data+carryOver)/10;
            }
            else
            {
                tail.next = new LinkedListNode((head1.data+head2.data+carryOver)%10);
                tail = tail.next;
                carryOver = (head1.data+head2.data+carryOver)/10;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1 != null)
        {
            if(head == null)
            {
                head = new LinkedListNode((head1.data+carryOver)%10);
                tail = head;
                carryOver = (head1.data+carryOver)/10;
            }
            else
            {
                tail.next = new LinkedListNode((head1.data+carryOver)%10);
                tail = tail.next;
                carryOver = (head1.data+carryOver)/10;
            }

            head1 = head1.next;
        }

        while(head2 != null)
        {
            if(head == null)
            {
                head = new LinkedListNode((head2.data+carryOver)%10);
                tail = head;
                carryOver = (head2.data+carryOver)/10;
            }
            else
            {
                tail.next = new LinkedListNode((head2.data+carryOver)%10);
                tail = tail.next;
                carryOver = (head2.data+carryOver)/10;
            }

            head2 = head2.next;
        }

        if(carryOver > 0)
        {
            if(head == null)
            {
                head = new LinkedListNode(carryOver);
                tail = head;
            }
            else
            {
                tail.next = new LinkedListNode(carryOver);
                tail = tail.next;
            }
        }

        return head;
    }
}
