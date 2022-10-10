// THE PROBLEM STATEMENT IS TO FIND THE MAXIMUM SUB-ARRAY SUM IN THE GIVEN ARRAY. 
// IF THE ARRAY IS EMPTY OR IT CONTAINS ONLY NEGATIVE INTEGERS, THEN THE SUM IS 0.

// THE BRUTE FORCE APPROACH WOULD BE TO CONSIDER ALL THE POSSIBLE SUB-ARRAY AND FIND THEIR SUM. 
// THEN RETURN THE MAXIMUM OF ALL THE POSSBLE SUM.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WELL, WE CAN OPTIMIZE THE ABOVE ALGORITHM TO CARRY OUT THE TASK IN LINEAR TIME.
// FOR THAT, WE WILL BE USING KADANE'S ALGORITHM, FOR WHICH WE WILL BE TRAVERSING THE ARRAY WHILE DOING SO WE WILL HAVE TWO
// VARIABLES IN HAND, ONE HOLDS THE MAXIMUM OF SUB-ARRAY SUM AND THE LATER WILL BE USED TO HOLD THE SUM OF CONTIGOUS VALUES
// IF AND ONLY IF THEIR SUM IS POSITIVE, IF THE VALUE GOES BELOW ZERO, WE RESET THE VALUE TO ZERO. THEN WE CHECK IF THE LATER
// VARIABLE HOLDS THE MAXIMUM OF SUB-ARRAY SUM FOR EACH ITERATION. 
// TIME COMPPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)



import java.util.* ;
import java.io.*; 

public class Solution 
{
	public static long maxSubarraySum(int[] arr, int n) 
	{
		long ans = 0,sum = 0;
        
        	for(int i=0;i<n;i++)
        	{
        	    sum += arr[i];
        	    if(sum < 0)
        	    {
        	        sum = 0;
        	    }
        	    ans = Math.max(ans,sum);
        	}
        
        	return ans;
	}

}
