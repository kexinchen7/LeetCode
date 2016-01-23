/*
  find all unique triplets in a given array of integers
  a+b+c = 0;

  NOTE:
  each (a,b,c) in non-descending order
  non duplicate triplets
 */

// solution 1, 

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        
        if(nums==null || nums.length<3) return res;
        
        Arrays.sort(nums);
        threeSum(nums, 0, 0, 0, res, cur);
        
        return res;
    }
    
    // start: index of beginning num
    // index: the index of element we need
    
    public static void threeSum(int[] nums, int index, int val, int start, List<List<Integer>> res, List<Integer> cur)
    {
        if(index == 3)
        {
            if(val == 0)
            {
                List<Integer> temp = new ArrayList<Integer>(cur);
                res.add(temp);  
            }
            return;
        }
        
        for(int i=start; i<=nums.length-(3-index); i++)
        {
            if(i!=start && nums[i] == nums[i-1])
                continue;
            cur.add(nums[i]);
            threeSum(nums, index+1, val+nums[i], i+1, res, cur);
            cur.remove(cur.size()-1);
        }
        return;
    }

   // solution 2
   // select the first one, then use two pointers to select the remaining two numbers
   /*
		be careful: there are two places to avoid duplicates
		the first is at line 70 to avoid duplicate for i. with two different forms: if(i==0 || nums[i]>nums[i-1]) or if(i!=0 && nums[i]==nums[i-1]) then continue;
		the second is at line avoid duplicate for j, k
    */

    public List<List<Integer>> threeSum(int[] nums) {
        int i, j, k;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 2)
            return result;
        Arrays.sort(nums);
        
        for(i=0; i<nums.length-2; i++)
        {
            int negate = -nums[i];
            
            if(i==0 || nums[i] > nums[i-1]) // avoid duplicates for the same negate
            {
                j = i+1;
                k = nums.length - 1;
                while(j < k)
                {
                    if(nums[j]+nums[k] == negate)
                    {
                        List<Integer> curRes = new ArrayList<Integer>();
                        curRes.add(nums[i]);
                        curRes.add(nums[j]);
                        curRes.add(nums[k]);
                        result.add(curRes);
                        // find the next pair whose sum equals the current negate 
                        j++;
                        k--;
                        // avoid that we find the same pairs
                        while(j<k && nums[j] == nums[j-1])
                            j++;
                        while(j<k && nums[k] == nums[k+1])
                            k--;
                        
                    }else if(nums[j] + nums[k] > negate)
                    {
                        k--;
                    }else
                    {
                        j++;  
                    }
                }
            }


        }
        return result;
    }