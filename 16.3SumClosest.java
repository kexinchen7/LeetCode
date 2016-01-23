/*
 3Sum closest

 find three integers such that sum is closest to a given number, return the sum;
 */

 // keep the minimum distance: compare the current distance and global distance
 // distance is the absolute difference
    public int threeSumClosest(int[] nums, int target) {
        
        if(nums == null || nums.length < 3)
            return Integer.MAX_VALUE;
            
        int minDist = Integer.MAX_VALUE;
        int result = 0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++)
        {
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                int curDist = Math.abs(sum- target);
                
                if(curDist == 0) return sum;
                
                if(curDist < minDist)
                {
                    minDist = curDist;
                    result = sum;
                }
                
                if(sum > target)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        
        return result;
    }
