/*
 * determine whether an integer is a palindrome. Do this without extra space
 *
 * NOTES: 
  1. assume negative integers are not palindrome, 
  2. when construct the reverse number, be careful the overflow
 */

// to deal with overflow, we convert to long first
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        long quot = x;
        long reverse  = 0;
        
        while(quot/10 != 0)
        {
            reverse = (reverse+quot%10)*10;
            quot = quot/10;
        }
        reverse += quot;
        System.out.println(reverse);

        return ((long)x==reverse)? true : false;
        
    }
