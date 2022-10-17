// THE PROBLEM STATEMENT IS TO ROTATE THE MATRIX BY 90 DEGREE.

// THE BRUTE FORCE APPROACH WOULD BE TO CREATE ANOTHER MATRIX THEN FILL THOSE MATRIX
// WITH THE ELEMENTS IN THE GIVEN MATRIX IN A CERTAIN ORDER.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*N)

// WELL, WE CAN FURTHER OPTIMISE IT BY CARRYING OUT THE SAME FUNCTION IN CONSTANT SPACE,
// SO, FIRST, WE NEED TO FIND THE TRANSPOSE OF THE MATRIX, THEN REVERSE EACH ROW OF THE MATRIX, WHICH
// WILL YIELD US THE SAME RESULT.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)    

import java.util.* ;
import java.io.*;

class Solution
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++)
        {
            int l = 0,r = (n-1);

            while(l < r)
            {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;

                l += 1;
                r -= 1;
            }
        }
    }
}
