public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        
        int global = nums[0];
        int minLocal = nums[0];
        int maxLocal = nums[0];
        
        /* for each element, keep the maxLocal and minLocal 
         * they are decided by: the previous maxLocal and minLocal and current nums[i]
         */
        for(int i=1; i<nums.length; i++)
        {
            int temp = minLocal;
            minLocal = Math.min(nums[i], Math.min(minLocal*nums[i], maxLocal*nums[i]));
            maxLocal = Math.max(nums[i], Math.max(temp*nums[i], maxLocal*nums[i]));
            global = Math.max(maxLocal, global);
        }
        
        return global;
    }
    
    /*
     * good test cases: [0,2,3,0,4,5], [-2,3,-4], [-3,0,1,-2], [2,-5,-2,-4,3]
     */
}