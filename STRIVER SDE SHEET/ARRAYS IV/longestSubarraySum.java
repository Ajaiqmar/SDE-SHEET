// THE PROBLEM STATEMENT IS TO FIND THE LENGTH LONGEST SUBARRAY WHOSE SUM IS EQUAL TO ZERO.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS TO IDENTIFY THE LENGTH OF THE LONGEST SUBARRAY WHOSE
// SUM IS EQUAL TO ZERO. THIS APPROACH WILL EXPLORE EVERY SINGLE POSSIBLE SUBARRAY TO
// CARRY OUT THE TASK AT HAND.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)

// WE CAN OPTIMISE IT WITH HELP OF PREFIX ARRAY AND HASHTABLE TO CARRY OUT THE TASK
// AT HAND IN LINEAR TIME. WELL, PREFIX ARRAY IS THE MODIFICATION OF THE GIVEN
// ARRAY WHERE THE VALUE AT EACH INDEX WILL BE THE SUM OF THE VALUES TOWARDS ITS LEFT
// INCLUDING THE CURRENT INDEX VALUE. NOW, ONCE WE HAVE A PREFIX ARRAY AT HAND,
// WE CAN DEDUCE THE LENGTH OF THE LONGEST SUBARRAY USING THE FOLLOWING INTUITION :

// ARR = [1,3,-1,4,-4]
// HERE THE LENGTH OF THE LONGEST SUBARRAY IS 2, WHICH IS [4,-4].
// NOW, THE PREFIX ARRAY IS [1,4,3,7,3]. IF YOU LOOK CLOSELY THE VALUE 3 HAS BEEN REPEATED TWICE,
// THIS HAPPENS BECAUSE THE SUM OF VALUES BETWEEN THOSE TWO INDICES IS ZERO, SO WE
// CAN USE A HASHMAP OR A DICTIONARY TO FIND OUT THESE INDICES AND FIGURE OUT THE LENGTH.

// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)


import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr)
    {
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int ans = 0;

        for(int i=0;i<arr.size();i++)
        {
            if(i != 0)
            {
                arr.set(i,arr.get(i)+arr.get(i-1));
            }
        }

        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i) == 0)
            {
                ans = Math.max(ans,(i+1));
            }
            else if(hashmap.get(arr.get(i)) == null)
            {
                hashmap.put(arr.get(i),i);
            }
            else
            {
                ans = Math.max(ans,i-hashmap.get(arr.get(i)));
            }
        }

        return ans;
	}
}
