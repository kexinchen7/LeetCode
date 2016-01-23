
// use two pointers, one at start, one at end, moving towards center
    public int maxArea(int[] height) {
        if(height==null || height.length<=1)
            return 0;
        
        int l = 0, r= height.length-1;
        int res = 0;
        
        while(l<r)
        {
            int cur = 0;
            if(height[r]>height[l])
            {
                cur = height[l]*(r-l);
                l++;
            }
            else
            {
                cur = height[r]*(r-l);
                r--;
            }
            
            res = Math.max(cur, res);
        }
        return res;
    }