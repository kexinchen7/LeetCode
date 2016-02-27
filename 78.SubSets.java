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
   			// no duplicate filter here
            cur.add(nums[i]);
            subsets(nums, i+1, res, cur);
            cur.remove(cur.size()-1);
        }
        return;
    }
}


// no recursion - method 1
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return res;
        }
        
        Arrays.sort(nums);
        int n = nums.length;
        
        /*
            each subset can be represent by value from 0..2^n-1
            if n = 3:
            000     []
            001     [1]
            010     [2]
            011     [1,2]
            ..
            110     [2,3]
            111     [1,2,3]
            
         */
        for(int i=0; i<(1<<n); i++) {
            List<Integer> cur = new ArrayList<Integer>();
            for(int j=0; j<n; j++) {
                if((i & (1<<j)) > 0){
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }
}

// no recursion - method 2
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> emptySet = new ArrayList<Integer>();
        res.add(emptySet);
        int curSize = 1;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<curSize; j++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(j));
                newSub.add(nums[i]);
                res.add(newSub);
            }
            curSize = res.size();
        }
        return res;
    }
}