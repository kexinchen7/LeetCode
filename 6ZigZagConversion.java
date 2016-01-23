/*
 
 mathematical relation behind is, 

1. index difference between any two neighboring columns

(2*numRows - 2)

2. 

 A       G
 B    F  H
 C  E    I 
 D    

 */

     public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows<=0)
            return "";
        if(numRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        int size = 2*numRows - 2;
        
        for(int i=0; i<numRows; i++)
        {
            for(int j=i; j<s.length(); j+=size)
            {
                res.append(s.charAt(j));
                if(i!=0 && i!=numRows-1 && j+size-2*i<s.length())
                    res.append(s.charAt(j+size-2*i));
            }
        }
        return res.toString();
    }