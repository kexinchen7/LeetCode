/*
difficulty is: find the correct range

method 2: slove by two binary search, the first is to find the minimum, then find in one half
*/


public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] < nums[end]) { // right sorted
                // eg. 6 7 0 (1) 2 3 4 5
                if(target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }

            } else {    // left sorted
                // eg. 3 4 5 (6) 7 0 1 2
                if(target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
                
            }
        }
        
        if(nums[start] == target) {
            return start;
        } else if(nums[end] == target) {
            return end;
        } else {
            return -1;
        }
        
    }
}