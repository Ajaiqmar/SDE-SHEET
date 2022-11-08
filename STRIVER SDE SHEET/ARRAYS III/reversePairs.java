// THE PROBLEM STATEMENT IS TO FIND THE NUMBER OF REVERSE PAIRS PRESENT IN THE ARRAY.
// A REVERSE PAIR IS TWO SETS OF INTERGERS WHICH SATISFY THE CONDITION ARR[I] > (ARR[J]*2) WHERE I > J.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS TO FIND THE NUMBER OF REVERSE PAIRS.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE THE BRUTE FORCE APPROACH WITH HELP OF MERGE SORT. WELL, IN THE MERGE PHASE OF THE MERGE SORT,
// WE CAN USE THE BROKEN SORTED HALVES OF THE ARRAY TO FIND THE NUMBER OF REVERSE PAIRS.
// TIME COMPLEXITY : O(N LOG N)
// SPACE COMPLEXITY : O(N)

import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void merge(ArrayList<Integer> arr,int l,int m,int r,int[] ans)
    {
        int[] temp = new int[((r-l)+1)];
        int ind = 0,i = l,j = m;

        while(i < m && j <= r)
        {
            if(arr.get(i) > (2*arr.get(j)))
            {
                j += 1;
                ans[0] += (m-i);
            }
            else
            {
                i += 1;
            }
        }

        i = l;
        j = m;

        while(i < m && j <= r)
        {
            if(arr.get(i) < arr.get(j))
            {
                temp[ind] = arr.get(i);
                i += 1;
            }
            else
            {
                temp[ind] = arr.get(j);
                j += 1;
            }

            ind += 1;
        }

        while(i < m)
        {
            temp[ind] = arr.get(i);
            i += 1;
            ind += 1;
        }

        while(j <= r)
        {
            temp[ind] = arr.get(j);
            j += 1;
            ind += 1;
        }

        for(int a=0,b = l;a<temp.length;a++,b++)
        {
            arr.set(b,temp[a]);
        }
    }

    public static void mergeSort(ArrayList<Integer> arr,int l,int r,int[] ans)
    {
        if(l < r)
        {
            int m = ((l+r)/2);

            mergeSort(arr,l,m,ans);
            mergeSort(arr,m+1,r,ans);

            merge(arr,l,m+1,r,ans);
        }
    }

    public static int reversePairs(ArrayList<Integer> arr)
    {
        int[] ans = new int[1];

        for(int i=0;i<arr.size();i++)
        {
            arr.set(i,2*arr.get(i));
        }

        mergeSort(arr,0,(arr.size()-1),ans);

        return ans[0];
    }
}
