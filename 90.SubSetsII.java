// non recursion
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> emptySet = new ArrayList<Integer>();
        result.add(emptySet);
        
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        
        int curSize = 1; // include empty set and first single number set
        int increaseAt = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            int pos = 0;
            if(i != 0 && nums[i] == nums[i-1]) {
                pos = increaseAt;
            }
            for(int j = pos; j < curSize; j++) {
                List<Integer> newSub = new ArrayList<Integer>(result.get(j));
                newSub.add(nums[i]);
                result.add(newSub);
            }
            /* record the increaseAt index */   
            increaseAt = curSize;
            curSize = result.size();
        }
        return result;
    }
    
    /* [] [1] 
     * [] [1] [2] [1 2] 
     * [] [1] [2] [1 2] [2 2] [1 2 2]
     * [] [1] [2] [1 2] [2 2] [1 2 2] [2 2 2] [1 2 2 2]
     *
     * if the next num is the same as the prev number, create new sub-lists from index - increaseAt
     */
}


// recursion 
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return res;
        }
        
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsets(nums, 0, res,cur);
        return res;
    }
    
    public void subsets(int[] nums, int pos, List<List<Integer>> res, List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        for(int i=pos; i<nums.length; i++){
            // duplicate filter
            if(i!=pos && nums[i]==nums[i-1]){
                continue;
            }
            cur.add(nums[i]);
            subsets(nums, i+1, res, cur);
            cur.remove(cur.size()-1);
        }
        return;
    }
}