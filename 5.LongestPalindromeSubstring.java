/*
 NOTE:
 assume the length of S is 1000
 there exists one unique longest palindromic substring
*/

 //solution 1 - DP

 /*
  P[n][n]

  P[i][j]
  1) = 1, if i==j
  2) = s.charAt(j) == s.charAt(j), if j=i+1
  3) = (s.charAt(j) == s.charAt(j) && P[i+1][j-1]), if j>i+1
  
  e.g. when n = 5
  you should fill following cells:
  P[0][0]
  P[0][1] P[1][1]
  P[0][2] P[1][2] P[2][2]
  P[0][3] P[1][3] P[2][3] P[3][3]
  P[0][4] P[1][4] P[2][4] P[3][4] P[4][4]

  each following step would rely on previous results
  */
    public String longestPalindrome(String s) {
        
        if(s==null || s.length()==0)    return "";
        
        int maxL = 1, start = 0, end = 0;
        
        boolean[][] P = new boolean[s.length()][s.length()];
        
        for(int i=0; i<s.length(); i++)
        {
            P[i][i] = true;
            for(int j=0; j<i; j++)
            {
                P[j][i] = (s.charAt(i)==s.charAt(j)) && (i==j+1 || P[j+1][i-1]);
                
                if(P[j][i] && maxL<i-j+1)
                {
                        maxL = i-j+1;
                        start = j;
                        end = i;
                }
            }
            
        }
    	return s.substring(start, end+1);
    }

// solution 2 - extend from a center

    public String longestPalindrome(String s) {
        
        if(s==null || s.length()==0)    return "";
        
        String longest = "";
        
        for(int i=0; i<s.length(); i++)
        {
            String temp = helper(s, i, i);
            if(longest.length() < temp.length())
                longest = temp;
                
            temp = helper(s, i, i+1);
            if(longest.length() < temp.length())
                longest = temp;
        }
        return longest;
    }
    
    public static String helper(String s, int start, int end)
    {
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }
        
        return s.substring(start+1, end);
    }