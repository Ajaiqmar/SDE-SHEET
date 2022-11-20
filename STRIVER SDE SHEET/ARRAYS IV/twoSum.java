// THE PROBLEM STATEMENT IS TO FIND INDICES OF A PAIR OF ELEMENTS IN THE GIVEN ARRAY
// WHOSE SUM IS EQUAL TO TARGET.

// THE BRUTE FORCE APPROACH IS TO USE TWO FOR LOOPS TO FIND THE PAIR.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE IT A BIT BY SORTING THE ARRAY, AFTER SORTING, WE CAN USE TWO
// POINTER APPORACH TO FIND THE PAIR.
// TIME COMPLEXITY : O(N*LOG N)
// SPACE COMPLEXITY : O(N)

// THE MOST OPTIMISED APPROACH WOULD BE TO USE A HASHMAP, THE INTUITION BEHIND THE APPROACH IS,
// SINCE THE TARGET IS ALREADY GIVEN, WE ONLY NEED TO CHCEK IF (TARGET - ARR[I]) EXIST IN THE GIVEN ARRAY.
// WITH THE HELP OF HASHMAP/DICTIONARY, IT IS JUST A CHILD'S PLAY.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;

class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++)
        {
            if(hashmap.get(target-nums[i]) != null)
            {
                ans[0] = hashmap.get(target-nums[i]);
                ans[1] = i;

                break;
            }

            hashmap.put(nums[i],i);
        }

        return ans;
    }
}
