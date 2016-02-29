/*
important properties:

num[i] ≠ num[i+1],
num[-1] = num[n] = -∞.

*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0, end = nums.length - 1;
        int mid;
        
        while(start + 1 < end) {
            mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]) {
                end = mid;
            } else if(nums[mid] < nums[mid+1]) {
                start = mid;
            }
        }
        
        if(nums[end] > nums[start]) {
            return end;
        }
        return start;
    }
}



