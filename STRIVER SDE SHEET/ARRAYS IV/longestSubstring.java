// THE PROBLEM STATEMENT IS TO RETURN THE LENGTH OF THE LONGEST SUBSTRING WHICH ONLY
// CONTAINS UNIQUE CHARACTERS.

// THE BRUTE FOR APPORACH WOULD BE TO USE TWO FOR LOOPS AND AN HASHTABLE,
// TO FIND THE LENGTH OF THE LONGEST SUBSTRING WITH UNIQUE CHARACTERS.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)

// WE CAN OPTIMISE THIS WITH THE HELP OS SLIDING WINDOW APPROACH, WHERE THERE WILL BE TWO
// POINTERS WHICH POINT TO TWO INDICES OF THE STRING, WHICH CONTAINS ONLY UNIQUE CHARACTERS.
// WE'LL INCREMENT AND DECREMENT THE SIZE OF THE SLIDING WINDOW ACCORDING TO THE GIVEN REQUIREMENT AND FIND THE LONGEST
// SUBSTRING LENGTH.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

import java.util.* ;
import java.io.*;
public class Solution
{
	public static int uniqueSubstrings(String input)
    {
	    int ans = 0;
        int i,j = 0;
        Boolean[] hashTable = new Boolean[256];

        for(i=0;i<input.length();i++)
        {
            int ind = input.charAt(i);

            if(hashTable[ind] == null)
            {
                hashTable[ind] = true;
                ans += 1;
            }
            else
            {
                break;
            }
        }

        while(i < input.length())
        {
            int lInd = input.charAt(j);
            int rInd = input.charAt(i);

            if(hashTable[rInd] == null)
            {
                hashTable[rInd] = true;
                i += 1;
            }
            else
            {
                hashTable[lInd] = null;
                j += 1;
            }

            ans = Math.max(ans,(i-j));
        }

        return ans;
	}
}
