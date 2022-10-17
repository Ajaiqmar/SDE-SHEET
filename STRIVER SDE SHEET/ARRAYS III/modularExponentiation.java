// THE PROBLEM STATEMENT IS TO FIND (X^N)%M. HERE, X, N AND M CAN BE FROM ANYWHERE BETWEEN 1 TO 10^9.

// THE BRUTE FORCE APPROACH WOULD BE TO USE FOR LOOP TO FIND (X^N), THEN USE MODULO OPERATOR
// TO FIND THE MODULO. BUT THIS WILL THROW TIME LIMIT EXCEEDED ERROR.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

// SO HOW CAN WE GO ABOUT IT YOU MAY ASK, WELL, YOU CAN ALWAYS USE DIVIDE AND CONQUER METHODOLOGY AND RECURSION IN THIS CASE
// TO OVERCOME SUCH LARGE CONSTRAINTS. HERE, THE INTUITION BEHIND THIS IS, WE CAN WRITE 2^4 AS ((2^2)*(2^2)), SO RATHER THAN CALCULATING
// THE SAME THING TWICE, YOU CAN DO IT ONCE AND USE THAT VALUE.
// TIME COMPLEXITY : O(LOG N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;

public class Solution
{
    public static int modularExponentiation(int x, int n, int m)
    {
        if(n == 1)
        {
            return x%m;
        }
        else
        {
            if(n%2 == 0)
            {
                long temp = modularExponentiation(x,n/2,m)%m;

                return (int)((temp*temp)%m);
            }
            else
            {
                long temp = modularExponentiation(x,n/2,m)%m;

                return (int)(((x%m)*((temp*temp)%m))%m);
            }
        }
    }
}
