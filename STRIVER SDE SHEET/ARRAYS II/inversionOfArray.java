// THE PROBLEM STATEMENT IS TO FIND THE COUNT OF INVERSIONS IN THE GIVEN ARRAY. AN INVERSION
// IS WHEN THE FOLLOWING CONDITION IS SATISFIED, ARR[I] > ARR[J] AND I < J.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS TO IDENTIFY THE NUMBER OF VALUES
// WHICH ARE GREATER THAN THE CURRENT INDEX VALUE TOWARDS ITS RIGHT.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE THE TIME COMPLEXITY FURTHER BY USING MERGE SORT, IN MERGE SORT, WE SUBDIVIDE THE
// ARRAY THEN MERGE THE ARRAY IN SORTED ORDER. WHILE MERGING WE CAN FIND THE INVERSION COUNT WHEN A HIGHER
// INDEX VALUE IS SMALLER THAN THE LOWER INDEX VALUES.
// TIME COMPLEXITY : O(N*LOG N)
// SPACE COMPLEXITY : O(1)


import java.util.* ;
import java.io.*;


public class Solution
{
    public static long merge(long arr[],int l,int m,int r)
    {
        int i = l,j = m;
        int n = ((r-l)+1);
        int ind = 0;
        long invCount = 0;
        long[] temp = new long[n];

        while(i < m && j <= r)
        {
            if(arr[i] <= arr[j])
            {
                temp[ind] = arr[i];
                i += 1;
            }
            else
            {
                temp[ind] = arr[j];
                j += 1;
                invCount += (m-i);
            }

            ind += 1;
        }

        while(i < m)
        {
            temp[ind] = arr[i];
            i += 1;
            ind += 1;
        }

        while(j <= r)
        {
            temp[ind] = arr[j];
            j += 1;
            ind += 1;
        }

        for(int a=0,b=l;a<temp.length;a++,b++)
        {
            arr[b] = temp[a];
        }

        return invCount;
    }

    public static long mergeSort(long arr[],int l,int r)
    {
        if(l < r)
        {
            long inversionCount = 0;
            int m = (r+l)/2;

            inversionCount += mergeSort(arr,l,m);
            inversionCount += mergeSort(arr,m+1,r);

            inversionCount += merge(arr,l,m+1,r);

            return inversionCount;
        }

        return 0;
    }

    public static long getInversions(long arr[], int n)
    {
        return mergeSort(arr,0,n-1);
    }
}
