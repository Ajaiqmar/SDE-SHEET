// THE PROBLEM STATEMENT IS TO FIND THE MAJORITY ELEMENT IN THE ARRAY AND RETURN IT.
// IF THERE IS NO MAJORITY ELEMENT, RETURN -1.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS AND FOR EACH INDEX,
// FIND THE COUNT OF THAT VALUE IN THE ARRAY. IF THE COUNT IS GREATER THAN (N/2), THEN RETURN
// THE MAJORITY ELEMENT.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WELL, YOU CAN BRING THIS DOWN TO LINEAR TIME, BY USING A HASHMAP/DICTIONARY TO STORE THE
// COUNT AND FIND THE MAJORITY ELEMENT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// IF YOU ASK, WHETHER WE CAN OPTIMISE IT EVEN MORE, WELL WE CAN CARRY OUT THE TASK IN CONSTANT SPACE.
// BOYER - MOORE VOTER ALGORITHM IS USED TO CARRY OUT THE TASK. WELL, SINCE THE MAJORITY ELEMENT IS THE ONE WHICH
// HAS A COUNT ABOVE (N/2) TIMES. WE CAN USE TWO VARIABLES ONE TO STORE THE VALUES IN THE ARRAY AND THE OTHER TO STORE THE COUNT OF IT.
// IF THE VALUE AT CURRENT INDEX MATCHES THE VALUE IN THE VOTER VARIABLE, INCREMENT THE COUNT, ELSE DECREMENT IT BY 1.
// IF THE COUNT REACHES ZERO, RE-ASSIGN THE TWO VARIABLES. WE CAN FIND THE MAJORITY ELEMENT USING THE ABOVE STEPS.
// NOW, SINCE THERE IS A POSSIBILITY THAT NO MAJORITY ELEMENT MAY EXIST IN THE ARRAY. WE NEED TO MAKE SURE OF IT, USING
// ANOTHER PASS OF THE ARRAY.
// TIME COMPLEXITY : O(N+N) ~ O(N)
// SPACE COMPLEXITY : O(1)


import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;

public class Solution {
	public static int findMajority(int[] arr, int n)
    {
		int voter = arr[0],count = 1;

        for(int i=0;i<n;i++)
        {
            if(count == 0)
            {
                voter = arr[i];
                count = 1;
                continue;
            }

            if(voter == arr[i])
            {
                count += 1;
            }
            else
            {
                count -= 1;
            }
        }

        count = 0;

        for(int i=0;i<n;i++)
        {
            if(voter == arr[i])
            {
                count += 1;
            }
        }

        if(count > (n/2))
        {
            return voter;
        }

        return -1;
	}
}
