// THE PROBLEM STATEMENT IS TO SORT THE GIVEN ARRAY WHICH CONTAINS ONLY 0's , 1's and 2's.

// THE BRUTE-FORCE APPROACH HERE WOULD BE TO JUST SIMPLY SORT THE ARRAY USING ANY ONE EFFICIENT SORTING ALGORITHM
// LIKE QUICK OR MERGE SORT.
// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(1)

// THE EFFICIENT APPROACH WOULD BE TO COUNT THE NUMBER OF 0's , 1's and 2's. THEN AGAIN TRAVERSE THE ARRAY, 
// THEN FILL EACH INDEX WITH 0 UNTIL THE NUMBER OF 0's IS ZERO, THEN START TO FILL THE EACH INDEX WITH 1 UNTIL
// THE NUMBER OF 1's IS ZERO, AND THEN FINALLY FILL THE REMAINING INDEX WITH 2 UNTIL THE NUMBER OF 2's IS ZERO.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

// CAN WE DO IT ONE PASS?? WELL, YES.
// HERE IS HOW IT GOES, WHILE TRAVERSING THE ARRAY IF THE VALUE AT THE CURRENT INDEX IS 0 THEN MOVE IT TO THE FRONT,
// ELSE IF THE VALUE AT THE CURRENT INDEX IS 2 THEN MOVE IT TO THE LAST, THE ONE'S WILL AUTOMATICALLY REARRANGE ITSELF WHILE
// DOING SO.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        int n = arr.length,i = 0,j = (n-1),k = 0;
        
        while(k <= j)
        {
            if(arr[k] == 0)
            {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                i += 1;
                k += 1;
            }
            else if(arr[k] == 2)
            {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                j -= 1;
            }
            else
            {
                k += 1;
            }
        }
    }
}