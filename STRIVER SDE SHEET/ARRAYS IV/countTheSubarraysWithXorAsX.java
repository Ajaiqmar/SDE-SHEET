// THE PROBLEM STATEMENT IS TO FIND NUMBER OF SUBARRAYS WHOSE XOR IS EQUAL TO X.

// THE BRUTE FORCE APPROACH IS TO USE TWO FOR LOOPS TO FIND THE SUBARRAYS.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE USING THE SAME APPROACH WE FOLLOWED IN LONGEST SUBARRAY SUM WHOSE SUM IS 0.
// WE JUST NEED TO MODIFY IT TO SUIT THE XOR OPERATION.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution
{
	public static int subarraysXor(ArrayList<Integer> arr, int x)
    {
		int ans = 0;

        for(int i=1;i<arr.size();i++)
        {
            arr.set(i,arr.get(i)^arr.get(i-1));
        }

        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();

        for(int i=0;i<arr.size();i++)
        {
            if(hashmap.get(arr.get(i)^x) != null)
            {
                ans += hashmap.get(arr.get(i)^x);
            }

            if(arr.get(i) == x)
            {
                ans += 1;
            }

            if(hashmap.get(arr.get(i)) == null)
            {
                hashmap.put(arr.get(i),1);
            }
            else
            {
                hashmap.put(arr.get(i),hashmap.get(arr.get(i))+1);
            }
        }

        return ans;
	}
}
