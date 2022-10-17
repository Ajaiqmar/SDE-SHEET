// THE PROBLEM STATEMENT IS TO SEARCH A MATRIX WHICH IS SORTED BOT ROWWISE AND COLUMNWISE IN ASCENDING ORDER.

// THE BRUTE FORCE APPROACH WOULD BE TO TRAVERSE THE MATRIX AND CHECK WHETHER THE TARGET EXISTS IN THE
// MATRIX OR NOT.
// TIME COMPLEXITY : O(M*N)
// SPACE COMPLEXITY : O(1)

// WE CAN OPTIMISE THIS FURTHER USING BINARY SEARCH, WHICH CAN REDUCE THE TIME COMPLEXITY.
// TIME COMPLEXITY : O(M*LOG N)
// SPACE COMPLEXITY : O(1)

// BUT CAN THIS BE OPTIMISED? WELL, OF COURSE, YES, SINCE WE HAVE THE ROWS AND COLUMNS SORTED, RATHER THAN TRAVERSING
// EACH ROW WHY DON'T WE MOVE IN A CERTAIN WAY THAT'LL HELP US TO LOCATE THE TARGET VALUE. LIKE, WE CAN START FROM THE
// LAST VALUE IN THE FIRST ROW, IF THE TARGET IS GREATER THAN THIS VALUE, WE MAY AS WELL IGNORE THE VALUES BEFORE IT.
// SO, MOVE DOWNWARDS ELSE IF THE TARGET IS SMALLER, WE MOVE TOWARDS RIGHT. THIS CAN HELP US TO PINPOINT THE TARGET VALUE.
// TIME COMPLEXITY : O(N+M)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution {
	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target)
  {
	   int i = 0,j = (n-1);

     while(i >= 0 && i < m && j >= 0 && j < n)
     {
       if(mat.get(i).get(j) == target)
       {
         return true;
       }
       else if(mat.get(i).get(j) > target)
       {
         j -= 1;
       }
       else
       {
         i += 1;
       }
     }

     return false;
	}
}
