// THE PROBLEM STATEMENT IS TO FIND THE NEXT PERMUTATION OF THE GIVEN PERMUTATION OF THE ARRAY CONTAINING 1 TO N.

// THE BRUTE FORCE APPROACH IS TO FIND ALL THE PERMUTAION OF THE GIVEN ARRAY, THEN SORT ALL THE PERMUTATION,
// WHICH CAN HELP US TO PINPOINT THE NEXT PERMUTATION OF THE GIVEN ARRAY.
// TIME COMPLEXITY : O(N!*N)
// SPACE COMPLEXITY : O(N!*N)

// WE CAN OPTIMIZE THIS USING THE FOLLOWING ALGORITHM :

// FIRSTLY, FIND THE INDEX WHERE THE CURRENT INDEX VALUE IS LESS THAN THE NEXT INDEX VALUE WHILE
// TRAVERSING FROM BACKWARDS. SECONDLY, FIND THE FIRST INDEX VALUE WHICH IS GREATER THAN
// THE VALUE AT THE INDEX WE FOUND AT THE FIRST STEP. THIRDLY, SWAP THE VALUE AT BOTH INDEX.
// FINALLY, REVERSE THE ARRAY FROM THE NEXT INDEX TO THE INDEX WHICH IS FOUND IN THE FIRST STEP.

// THE INTUITION BEHIND THIS IS, IF LET'S SAY, WE HAVE AN ARRAY ARR = [1,3,5,4,2], THE NEXT PERMUTATION WOULD BE [1,4,2,3,5]
// NOW, IF YOU CONSIDER THE INITIAL ARRAY,
// THE ARRAY CAN BE ARRANGED LIKE THIS :
//     5
//   3   4
// 1       2
// WHERE WHEN WE LOOK FROM BACKWARDS, IT IS ALWAYS A DECREASING SEQUENCE, SO, FIRST WE NEED TO FIND THE BREAKING
// POINT WHICH IS 3 AND 5. NOW, WE NEED TO CHANGE THE VALUE AT 3. SO, THEN WE FIND THE VALUE THAT IS GREATER THAN 3 IN THE DECREASING
// SEQUENCE. AFTER FINDING IT, WE NEED TO SWAP IT. SINCE WE NEED THE PERMUTATION TO BE AS CLOSE AND SMALL AS POSSIBLE, WE
// NEED TO REVERSE THE DECREASING SEQUNCE.

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N) 

import java.util.* ;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void reverse(ArrayList<Integer> arr,int l,int r)
    {
        while(l < r)
        {
            int temp = arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,temp);

            l += 1;
            r -= 1;
        }
    }

	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation)
	{
		int n = permutation.size(),i = (n-2),j = (n-1);

        while(i >= 0)
        {
            if(permutation.get(i) < permutation.get(i+1))
            {
                break;
            }

            i -= 1;
        }

        while(j >= 0)
        {
            if(i >= 0 && permutation.get(i) < permutation.get(j))
            {
                break;
            }

            j -= 1;
        }

        if(i >= 0 && i < n && j >= 0 && j < n)
        {
            int temp = permutation.get(i);
            permutation.set(i,permutation.get(j));
            permutation.set(j,temp);
        }

        reverse(permutation,i+1,n-1);

        return permutation;
	}
}
