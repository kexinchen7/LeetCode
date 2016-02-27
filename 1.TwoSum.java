/*

Input: numbers = {2,7,11,15}, target = 9
Output: index1 = 1, index2 = 2

NOTE: assume have exactly one solution

*/


// solution 1 - naive way using brute force
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 0, k=0;
        int[] index_val={0,0};
        for(i=0; i<nums.length; i++)
        {
            for(j=i+1; j<nums.length; j++)
            {
                if( (nums[i]+nums[j]) == target)
                {
                    index_val[k++] = i+1;
                    index_val[k++] = j+1;
                }
            }
        }
        
        return index_val;
    }

// solution 2 - using HashMap
// first to store (target-nums[i], i)
// then if key nums[j] already exists, return i,j
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                result[0] = map.get(nums[i]) + 1;
                result[1] = i+1;
            }
            else
            {
                map.put(target-nums[i], i);
            }
        }
        return result;
    }

