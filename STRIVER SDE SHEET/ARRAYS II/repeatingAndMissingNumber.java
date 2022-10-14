// THE PROBLEM STATEMENT IS TO FIND THE REPEATING NUMBER AND MISSING NUMBER IN TH GIVEN ARRAY.
// THE GIVEN ARRAY WILL CONTAIN THE RANGE 1 TO N AND THERE WILL BE EXACTLY ONE REPEATED ELEMENT AND ONE MISSING ELEMENT.
// THE REPEATED ELEMENT IS GOING TO BE FROM 1 TO N.

// THE BRUTE FORCE APPROACH WOULD BE TO USE A DICTIONARY / HASHMAP, TO FIND THE REPEATED ELEMENT AND
// THE MISSING ELEMENT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// CAN WE DO IT IN CONSTANT SPACE?? WELL, YES, WE CAN USE THE GIVEN ARRAY AS AN HASHMAP/DICTIONARY TO FIND THE
// THE REPEATING ELEMENT AND THE MISSING ELEMENT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n)
    {
        int[] ans = new int[2];

        for(int i=0;i<n;i++)
        {
            int ind = Math.abs(arr.get(i))-1;

            if(arr.get(ind) > 0)
            {
                arr.set(ind,-arr.get(ind));
            }
            else
            {
                ans[1] = Math.abs(arr.get(i));
            }
        }

        for(int i=0;i<n;i++)
        {
            if(arr.get(i) > 0)
            {
                ans[0] = (i+1);
                break;
            }
        }

        return ans;
    }
}
