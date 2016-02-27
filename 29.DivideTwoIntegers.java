/*

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

*/

public class Solution {
    public int divide(int dividend, int divisor) {
        
        // when -2^31 / -1 equals 2^31-1
        if(divisor == 0)    return Integer.MAX_VALUE;
        if(divisor==-1 && dividend==Integer.MIN_VALUE )  return Integer.MAX_VALUE;
        int res = 0;
        
        // abs, extend
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        
        while(pDividend >= pDivisor)
        {
            int shift = 1;
            while(pDividend >= (pDivisor<<shift))
                shift++;
            
            shift--;
            res += 1<<shift;
            pDividend -= (pDivisor<<shift);
        }
        return ((dividend^divisor) >=0 ) ? res : -res ;

    }
}

