// negative: reverse the absolute value, then append the sign
// overflow: extend to long, when reverse 2^31-1 and -2^31, return 0;

    public int reverse(int x) {
        // negative
        // overflow
        
        long res = 0;
        long quot = Math.abs((long)x);
        
        while(quot/10 != 0)
        {
            res = (res+quot%10)*10;
            quot = quot/10;
        }
        
        res += quot;
        
        if(res > Integer.MAX_VALUE)
            res = 0;
            
        return (x<0) ? -(int)res : (int)res;
    }