// two situation: 
// 0 1 2 3 4 5 6 7
// 3 4 5 6 7 0 1 2
// 6 7 0 1 2 3 4 5


public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        // if there is no rotation
        if(nums[start] < nums[end]) return nums[start];

        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return Math.min(nums[start], nums[end]);
        
    }
}

// each time compare the mid with the end
// avoid removing the left part when no rotation
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
 
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return Math.min(nums[start], nums[end]);
        
    }
}

// nine chapter reference code
/* the rotated sorted array looks like this:
              __|  
            __  |
          __    |
        __      |
      __        |
________________|_____________________
                |       
                |     
                |      __(last number here)
                |   __|
                |__|
                |(smallest number here)

Obviously, the goal is to find the first position that <= last number
*/
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int target = nums[nums.length-1];
        // find the first element <= target
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(nums[start] <= target) {
            return nums[start];
        } else{
            return nums[end];
        }        
    }
}



// follow-up: what if there is duplicate


