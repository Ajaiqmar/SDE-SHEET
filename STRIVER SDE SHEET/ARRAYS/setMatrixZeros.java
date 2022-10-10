// THE PROBLEM STATEMENT IS WHEN GIVEN AN INTEGER MATRIX OF DIMENSIONS NxM, IF AN ELEMENT AT A PARTICULAR CELL IS 0,
// MARK ALL THE ELEMENTS ALONG ITS ROW AND COLUMN TO BE ZERO.

// NOW, ABOUT THE SOLUTION,

// THE BRUTE FORCE APPROACH WOULD BE TO CREATE A DUPLICATE ARRAY AND SET ALL THE ELEMENTS ALONG THE ROW AND COLUMN TO BE ZERO
// IF A PARTICULAR CELL IS ZERO.
// TIME COMPLEXITY : O((N*M)*MAX(N,M))
// SPACE COMPLEXITY : O(N*M)

// NOW, WE CAN FURTHER OPTIMIZE IT BY USING TWO BOOLEAN ARRAYS OF LENGTH N AND M, RATHER THAN RECREATING THE WHOLE MATRIX.
// WELL, HOW MIGHT THIS GO IS THAT, WHILE TRAVERSING IF A PARTICULAR CELL IS ZERO, WE WILL MARK DOWN THE PARTICULAR ROW AND COLUMN
// IN THE BOOLEAN ARRAYS. SO THAT WHEN WE ARE RETRAVERSING IT, IF A PARTICULAR CELLS ROW INDEX OR COLUMN INDEX IS TRUE IN THAT BOOLEAN
// ARRAYS, WE WILL CHANGE IT TO ZERO.
// TIME COMPLEXITY : O(N*M)
// SPACE COMPLEXITY : O(N+M)

// CAN YOU DO THIS IN CONSTANT MEMORY?
// WELL GLAD YOU ASKED, YES, OF COURSE, INSTEAD OF USING TWO BOOLEAN ARRAYS, WE CAN USE THE FIRST ROW AND COLUMN TO DO THE
// BOOLEAN ARRAYS JOB. THE SOURCE CODE FOR HIS APPROACH IS DOWN BELOW.
// TIME COMPLEXITY : O(N*M)
// SPACE COMPLEXITY : O(1)


import java.util.* ;
import java.io.*;

public class Solution
{
    public static void setZeros(int matrix[][])
    {
        int r = matrix.length,c = matrix[0].length;
        int firstRow = 0,firstCol = 0;

        for(int i=0;i<r;i++)
        {
            if(matrix[i][0] == 0)
            {
                firstCol = 1;
            }
        }

        for(int i=0;i<c;i++)
        {
            if(matrix[0][i] == 0)
            {
                firstRow = 1;
            }
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow == 1)
        {
            for(int i=0;i<c;i++)
            {
                matrix[0][i] = 0;
            }
        }

        if(firstCol == 1)
        {
            for(int i=0;i<r;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
