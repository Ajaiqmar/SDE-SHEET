// THR PROBLEM STATEMENT IS TO FIND THE MAJORITY ELEMENTS IN AN ARRAY. IN THIS CASE, MAJORITY ELEMENT IS THE
// ELEMENT WHICH HAS BEEN REPEATED MORE THAN (N/3) TIMES.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS AND FOR EACH INDEX,
// FIND THE COUNT OF THAT VALUE IN THE ARRAY. IF THE COUNT IS GREATER THAN (N/23), THEN RETURN
// THE MAJORITY ELEMENT.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WELL, YOU CAN BRING THIS DOWN TO LINEAR TIME, BY USING A HASHMAP/DICTIONARY TO STORE THE
// COUNT AND FIND THE MAJORITY ELEMENT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(N)

// IF YOU ASK, WHETHER WE CAN OPTIMISE IT EVEN MORE, WELL WE CAN CARRY OUT THE TASK IN CONSTANT SPACE.
// BOYER - MOORE VOTER ALGORITHM IS USED TO CARRY OUT THE TASK. WELL, SINCE THE MAJORITY ELEMENT IS THE ONE WHICH
// HAS A COUNT ABOVE (N/3) TIMES. WE CAN USE FOUR VARIABLES TWO TO STORE THE VALUES IN THE ARRAY AND THE OTHER TWO TO STORE THE COUNT OF IT.
// IF THE VALUE AT CURRENT INDEX MATCHES THE VALUE IN THE EITHER OF THE TWO VARIABLE, INCREMENT THE COUNT, ELSE DECREMENT IT BY 1.
// IF THE COUNT REACHES ZERO, RE-ASSIGN THE TWO VARIABLES. WE CAN FIND THE MAJORITY ELEMENT USING THE ABOVE STEPS.
// NOW, SINCE THERE IS A POSSIBILITY THAT NO MAJORITY ELEMENT MAY EXIST IN THE ARRAY. WE NEED TO MAKE SURE OF IT, USING
// ANOTHER PASS OF THE ARRAY.
// TIME COMPLEXITY : O(N+N) ~ O(N)
// SPACE COMPLEXITY : O(1)


import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int a = -1,b = -1,c1 = 0,c2 = 0,n = arr.size();

        for(int i=0;i<n;i++)
        {
            if(arr.get(i) == a)
            {
                c1 += 1;
            }
            else if(arr.get(i) == b)
            {
                c2 += 1;
            }
            else if(c1 == 0)
            {
                a = arr.get(i);
                c1 = 1;
            }
            else if(c2 == 0)
            {
                b = arr.get(i);
                c2 = 1;
            }
            else
            {
                c1 -= 1;
                c2 -= 1;
            }
        }

        c1 = 0;
        c2 = 0;

        for(int i=0;i<n;i++)
        {
            if(arr.get(i) == a)
            {
                c1 += 1;
            }
            else if(arr.get(i) == b)
            {
                c2 += 1;
            }
        }

        if(c1 > (n/3))
        {
            ans.add(a);
        }

        if(c2 > (n/3))
        {
            ans.add(b);
        }

        return ans;
    }
}
