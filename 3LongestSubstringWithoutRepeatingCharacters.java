/*
 Given a string, find the longest substring withour repeating characters
 */

/*
NOTE: some tricky cases
bbabcd
aasde
pwwkew
 */

// iterate each character
// keep the start index of each non-repeating string
// every time find a repeat character, start begin right after this character
    public int lengthOfLongestSubstring(String s) {
       if(s==null || s.length() == 0)   return 0;
       
       int res = 1;
       // start index for any one satisfied string 
       int start = 0;
       
       // buffer to record whether the character occurs before 
       boolean[] visited = new boolean[256];
       visited[s.charAt(0)] = true;

       for(int i=1; i<s.length(); i++)
       {
           char cur = s.charAt(i);
           // if the current character haven't appear so far
           if(!visited[cur])
           {
               visited[cur] = true;
               res = Math.max(res, i-start+1);
           }
           else
           {
               // start begin right after the repeating character 
               while(s.charAt(start) != cur)
               {
                   visited[s.charAt(start)] = false;
                   start++;
               }
               start++;
           }
       }
       return res;
    }