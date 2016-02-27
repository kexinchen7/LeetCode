/*
an array: ith val is the price of the given stock on day i
you are only allowed to complete at most one transaction(i2, buy one and sell one share f the stock only once)
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int local = 0;
        int global = 0;
        
        for(int i=1; i<prices.length; i++)
        {
            int diff = prices[i] - prices[i-1];
            local = (local+diff <= 0)? 0 : local+diff;
            global = Math.max(local, global);
        }
        
        return global;
    }
}