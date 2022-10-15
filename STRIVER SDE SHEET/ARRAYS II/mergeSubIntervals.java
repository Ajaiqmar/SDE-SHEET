// THE PROBLEM STATEMENT IS TO MERGE ALL OVERLAPPING INTERVALS AND RETURN THE LIST OF MERGED INTERVALS.
// EACH INTERVAL CONTAINS START TIME AND END TIME FOR THE INTERVAL.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS AND CHECK IF THE CURRENT INTERVAL IS
// ALREADY VISITED, IF IT IS NOT, THEN FIND IF ANY OTHER INTERVALS ARE OVERLAPPING, IF IT IS THEN
// MERGE IT.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(N)

// WE CAN OPTIMISE THE TIME COMPLEXITY BY SORTING THE ARRAY USING THE START AND END TIME OF EACH INTERVAL,
// THEN MERGE THE INTERVALS THAT ARE OVERLAPPING BY TRAVERSING THE SORTED INTERVAL ARRAY.
// TIME COMPLEXITY : O(N*LOG N)
// SPACE COMPLEXITY : O(N)


import java.util.* ;
import java.io.*;

/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals)
    {
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                if(i1.start == i2.start)
                {
                    return i1.finish-i2.finish;
                }

                return i1.start-i2.start;
            }
        });

        List<Interval> ans = new ArrayList<Interval>();
        Interval temp = new Interval(0,0);
        temp.start = intervals[0].start;
        temp.finish = intervals[0].finish;

        for(int i=1;i<intervals.length;i++)
        {
            if(temp.start <= intervals[i].start && temp.finish >= intervals[i].start)
            {
                temp.finish = Math.max(temp.finish,intervals[i].finish);
            }
            else
            {
                ans.add(temp);
                temp = new Interval(0,0);
                temp.start = intervals[i].start;
                temp.finish = intervals[i].finish;
            }
        }

        ans.add(temp);

        return ans;
    }
}
