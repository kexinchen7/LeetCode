/*
an array: ith val is the price of the given stock on day i
you are only allowed to complete as many transactions as you can(ie, buy one and sell one share of the stock multiple times)
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int global = 0;
        
        for(int i=1; i<prices.length; i++)
        {
            int diff = prices[i] - prices[i-1];
            
            if(diff >= 0)
                global += diff;
        }
        
        return global;        
    }
}

