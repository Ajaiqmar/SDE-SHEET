// THE PROBLEM STATEMENT IS TO CREATE A PASCAL'S TRAINGLE UPTO ROW N, STORE IT IN A 2D MATRIX.
// I.E. LET'S SAY N IS 6, THEN THE,
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// 1 5 10 10 5 1

// THE APPROACH HERE WOULD BE TO CONSTRUCT EACH ROW USING THE LAST INSERTED ROW,
// IF THE ROW INDEX IS 0, INSERT THE ARRAY [1], THEN, FOR THE REST OF THE ROWS,
// CREATE AN ARRAY WHERE ELEMENTS AT EACH INDEX IS EQUAL TO MATRIX[I-1][J]+MATRIX[I-1][J-1] EXCEPT FOR THE ZERO-TH INDEX.
// FOR THE ZERO-TH INDEX, INSERT 1.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N*N)


import java.util.* ;
import java.io.*;
import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n)
    {
        ArrayList<ArrayList<Long>> ans = new ArrayList<ArrayList<Long>>();

        for(int i=0;i<n;i++)
        {
            if(i == 0)
            {
                ArrayList<Long> temp = new ArrayList<Long>();
                temp.add((long)1);

                ans.add(temp);
            }
            else
            {
                ArrayList<Long> temp = ans.get(ans.size()-1);
                ArrayList<Long> newRow = new ArrayList<Long>();

                newRow.add((long)1);

                for(int j=1;j<temp.size();j++)
                {
                    newRow.add(temp.get(j)+temp.get(j-1));
                }

                newRow.add((long)1);

                ans.add(newRow);
            }
        }

        return ans;
	}
}
