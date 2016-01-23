// solution 1 is pretty similar to recursive solution of 3Sum. But it would generate "Time Limit Exceeds" 
// when deal with large array

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        
        if(nums==null || nums.length<4) return res;
        
        Arrays.sort(nums);
        fourSum(nums, 0, target, 0, res, cur);
        
        return res;
    }
    
    // start: index of beginning num
    // index: the index of element we need
    
    public static void fourSum(int[] nums, int index, int val, int start, List<List<Integer>> res, List<Integer> cur)
    {
        if(index == 4)
        {
            if(val == 0)
            {
                List<Integer> temp = new ArrayList<Integer>(cur);
                res.add(temp);  
            }
            return;
        }
        
        for(int i=start; i<=nums.length-(4-index) && nums[i]<=val; i++)
        {
            if(i!=start && nums[i] == nums[i-1])
                continue;
            cur.add(nums[i]);
            fourSum(nums, index+1, val-nums[i], i+1, res, cur);
            cur.remove(cur.size()-1);
        }
        return;
    }

// solution 2
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length <= 3)
            return result;
        
        Arrays.sort(nums);

        int i, j, k, l;
        for(i=0; i<nums.length-3; i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;

            for(j=i+1; j<nums.length-2; j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;

                    k = j+1;
                    l = nums.length - 1;
                    int negate = target - nums[i] - nums[j];
                    while(k < l)
                    {
                        if(nums[k]+nums[l] == negate)
                        {
                            List<Integer> curRes = new ArrayList<Integer>();
                            curRes.add(nums[i]);
                            curRes.add(nums[j]);
                            curRes.add(nums[k]);
                            curRes.add(nums[l]);
                            result.add(curRes);
                            // find the next pair whose sum equals the current negate 
                            k++;
                            l--;
                            // avoid that we find the same pairs
                            while(k<l && nums[k] == nums[k-1])
                                k++;
                            while(k<l && nums[l] == nums[l+1])
                                l--;
                            
                        }else if(nums[k] + nums[l] > negate)
                        {
                            l--;
                        }else
                        {
                            k++;  
                        }
                    }
                }
        }
        return result;
    }