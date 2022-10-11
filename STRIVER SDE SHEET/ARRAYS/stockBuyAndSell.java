// THE PROBLEM STATEMENT IS TO FIND THE MAXIMUM PROFIT THAT CAN BE MADE, GIVEN THE STOCK PRICES
// OF AN INSTANCE. YOU CAN BUY AND SELL THE STOCK ONLY ONCE.

// THE BRUTE FORCE APPROACH WOULD BE TO USE TWO FOR LOOPS AND CONSIDER EVERY PAIR OF INDICES,
// THEN FIND THEIR DIFFERENCE TO IDENTIFY THE MAXIMUM OF ALL.
// TIME COMPLEXITY : O(N*N)
// SPACE COMPLEXITY : O(1)

// WELL, WE CAN OPTIMIZE IT FURTHER, BY FINDING THE LOCAL MINIMUM FOR EACH INDEX ON ITS LEFT
// THEN FIND DIFFERENCE OF THE CURRENT INDEX VALUE FROM THE LOCAL MINIMUM, COMPARE THIS VALUE TO CHECK
// IF THIS IS THE MAXIMUM OF ALL. THEN FINALLY, RETUNR THE PROFIT.
// TIME COMPLEXITY : O(N)
// SPACE COMPLEXITY : O(1)

import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static int maximumProfit(ArrayList<Integer> prices)
    {
        int lowStockPrice = prices.get(0),ans = 0;

        for(int i=0;i<prices.size();i++)
        {
            lowStockPrice = Math.min(lowStockPrice,prices.get(i));
            ans = Math.max(ans,prices.get(i)-lowStockPrice);
        }

        return ans;
    }
}
