/*
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
// if there is no duplicate in array
public class Solution {
    
    // find the first position that >= target
    // or the (last position < target) + 1
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else if(nums[mid] > target) {
                end = mid;
            }
        }
        
        if(nums[start] >= target) {
            return start;
        } else if(nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }
}



// binary search solution if there is duplicates in array
// test cases: insert 5 into [4, 4] [4, 5], [5,5]
public class Solution {
    
    // find the first position that >= target
    // or the (last position < target) + 1
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] >= target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            }
        }
        // find the last position that < target, then plus 1
        if(nums[end] < target) {
            return end+1;
        } else {
            if(nums[start] < target) {
                return start+1;
            } else {
                return start;
            }
        }
    }
}

// also a solution if there is duplicates in array
public class Solution {
    
    // find the first position that >= target
    // or the (last position < target) + 1
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else if(nums[mid] > target) {
                end = mid;
            }
        }
        // find the first position that >= target
        if(nums[start] >= target) {
            return start;
        } else {
            if(nums[end] >= target) {
                return end;
            } else {
                return end+1;
            }
        }
    }
}