// THE PROBLEM STATEMENT HERE IS TO CHECK WHETHER THERE EXISTS ARR[I]+ARR[J]+ARR[K]+ARR[L] IS EQUAL TO THE
// GIVEN TARGET VALUE. HERE, I,J,K AND L ARE UNIQUE VALUES. THERE ARE SO MANY VARIATIONS OF FOUR SUM PROBLEM.

// THE BRUTE FORCE APPROACH WOULD BE TO USE 4 FOR lOOPS TO IDENTIFY WHETHER THE GIVEN
// CONDITION EXISTS.
// TIME COMPLEXITY : O(N^4)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE THIS BY SORTING THE GIVEN ARRAY, THEN WE ONLY NEED THREE FOR LOOPS AN TWO POINTERS TO
// IDENTIFY WHETHER THE GIVEN CONDITION EXISTS.
// TIME COMPLEXITY : O(N^3)
// SPACE COMPLEXITY : O(1)

// FOR THIS PARTICULAR INSTANCE, WE CAN OPTIMISE IT EVEN FURTHER, WE CAN STORE SUM OF ALL THE PAIRS IN THE ARRAY
// IN AN HASHMAP, THEN USE THAT TO CHECK WHETHER THE GIVEN CONDITION EXISTS.
// TIME OMPLEXITY : O(N^2)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;

public class Solution
{
  public static String fourSum(int[] arr, int target, int n)
  {
      Arrays.sort(arr);

      for(int i=0;i<(n-1);i++)
      {
          for(int j=(i+1);j<n;j++)
          {
              int left = (j+1),right = (n-1);

              while(left < right)
              {
                  int s = (arr[i]+arr[j]+arr[left]+arr[right]);

                  if(s == target)
                  {
                      return "Yes";
                  }
                  else if(s < target)
                  {
                      left += 1;
                  }
                  else
                  {
                      right -= 1;
                  }
              }
          }
      }

      return "No";
  }
}
