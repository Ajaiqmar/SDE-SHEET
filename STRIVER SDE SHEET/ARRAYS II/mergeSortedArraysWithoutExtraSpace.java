// THE PROBLEM STATEMENT IS TO MERGE THE GIVEN TWO SORTED ARRAYS WITHOUT ANY EXTRA SPACE.
// THE GIVEN ARRAY ARR1 IS OF LENGTH m+n WHERE m AND n IS THE LENGTH OF THE TWO SORTED ARRAYS.

// THE APPROACH HERE WOULD BE TO TRAVERSE BACKWARDS BOTH THE ARRAYS USING TWO POINTERS i AND j.
// WHILE TRAVERSING CHECK IF ELEMENT AT INDEX I IS GREATER OR ELEMENT AT INDEX J IS GREATER, WHICHEVER IS THE GREATEST
// ONE MOVE IT TO THE END OF THE ARR1.
// TIME COMPLEXITY : O(N+M)
// SPACE COMPLEXITY : O(1)


import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n)
    {
        int i = (m-1),j = (n-1),k = ((m+n)-1);

        while(i >= 0 && j >= 0)
        {
            if(arr1[i] > arr2[j])
            {
                arr1[k] = arr1[i];
                i -= 1;
                k -= 1;
            }
            else
            {
                arr1[k] = arr2[j];
                j -= 1;
                k -= 1;
            }
        }

        while(i >= 0)
        {
            arr1[k] = arr1[i];
            i -= 1;
            k -= 1;
        }

        while(j >= 0)
        {
            arr1[k] = arr2[j];
            j -= 1;
            k -= 1;
        }

        return arr1;
    }
}
