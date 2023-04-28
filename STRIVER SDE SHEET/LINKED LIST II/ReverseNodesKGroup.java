// THE PROBLEM STATEMENT IS TO REVERSE THE LINKED LIST IN A GROUP OF K ELEMENTS AT A TIME. K IS GIVEN IN THE
// FORM OF A LIST OF INTEGERS. IF THE NUMBER OF ELEMENTS IN THE LINKED LIST IS LESS THAN ELEMENT AT ANY INDEX
// THEN REVERSE ONLY THE NODES AVAILABLE. IF THE NUMBER OF NODES IN THE LINKED LIST IS HIGHER
// JUST APPEND THE REST WITHOUT REVERSING.

// THE BRUTE FORCE APPROACH WOULD BE TO USE A FOR LOOP AND THE TRAVERSE THE GIVEN ARRAY, WHILE DOING SO
// CALL A HELPER FUNCTION WHICH USES RECURSION AND A STACK TO REPLACE THE VALUES IN THE LINKED LIST, WE JUST HAVE TO
// PASS THE PARAMETER AS THE HEAD OF EACH GROUP AND THE VALUE K WHICH REPRESENTS THE LENGTH OF THE GROUP.

// TIME COMPLEXITY : O(M*N), M IS THE LENGTH OF THE ARRAY WHICH CARRIES THE LENGTH OF EACH GROUP AND FOR EACH
// HELPER FUNCTION CALL WE NEED TO GET THE HEAD OF THE GROUP WHICH CAN TAKE AS MUCH AS LNGTH OF THE LINKED LIST WHICH IS N. WE
// WON'T CONSIDER THE STACK DEPTH AS IT IS ALWAYS GOING TO BE LESS THAN OR EQUAL TO N .

// SPACE COMPLEXITY : O(N), IN THE WORST CASE SCENARIO THE LENGTH OF THE GROUP COULD BE N.


import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) 
	{
		Node newHead = null;
		Node newTail = null;
		Node temp = head;
		int ind = 0;

		while(temp != null && ind < b.length)
		{
			Node tempHead = null;
			Node tempTail = null;

			while(b[ind] > 0 && temp != null)
			{
				if(tempHead == null)
				{
					tempHead = temp;
					tempTail = temp;
					temp = temp.next;
					tempHead.next = null;
				}
				else
				{
					Node tempNode = temp;
					temp = temp.next;
					tempNode.next = tempHead;
					tempHead = tempNode;
				}

				b[ind] -= 1;
			}

			if(newHead == null && tempHead != null)
			{
				newHead = tempHead;
				newTail = tempTail;
			}
			else if(tempTail != null)
			{
				newTail.next = tempHead;
				newTail = tempTail;
			}

			ind += 1;
		}

		if(temp != null)
		{
			if(newTail == null)
			{
				return temp;
			}
			
			newTail.next = temp;
		}

		return newHead;
	}
}