
    public int myAtoi(String str) {
        // negative number "-12"
        // white space before first non-white-space character
        // non-numeric characters following the last numeric character
        // first non-white-space character 
        // value overflow
        
        if(str==null || str.length()==0)
            return 0;
        
        int sign = 1;
        long res = 0;
        int i = 0;
        // skip all white-space starting from the beginning
        while(i<str.length() && str.charAt(i)==' ')
        {
            i++;
            if(i==str.length()) return 0;
        }
        // after the white-spaces, check sign
        if(str.charAt(i)=='+' || str.charAt(i)=='-')
        {
            sign = (str.charAt(i) == '-') ? -1 : sign;
            i++;
        }
        // whether sign is given or not, find all numbers util meet non-numeric characters. 
        // if no number exists, this step is ignored.
        while(i<str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0' )
        {

            res = res*10 + str.charAt(i)-'0';
            i++;
            
            if(sign==1 && res >= Integer.MAX_VALUE )
            {
                res = Integer.MAX_VALUE;
                return (int)res;
            }
            
            if(sign==-1 && res >= (long)Integer.MAX_VALUE+1)
            {
                res = Integer.MIN_VALUE;
                return (int)res;
            }
        }
        // be careful: Integer.MAX_VALUE+1 = -2^31
        // System.out.println(Math.abs(Integer.MAX_VALUE)+1); // -2^31
        // System.out.println((long)(Integer.MAX_VALUE)+1); // 2^31
        
        return (sign==1) ? (int)res : -(int)res ;
    }