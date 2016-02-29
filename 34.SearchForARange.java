

// improved solution using binary search
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null)    return new int[]{-1, -1};
        return new int[]{find(nums, target, 0), find(nums, target, 1)};
    }
    
    // flag = 1 : find the last position, flag = 0: find the first position
    public static int find(int[] nums, int target, int flag) {
        
        if(nums == null || nums.length == 0)    return -1;
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target) {
                if(flag == 1) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if(nums[mid] > target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            }
        }
        
        if(flag == 1) {
            if(nums[end] == target) {
                return end;
            } else if(nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else {
            
            if(nums[start] == target) {
                return start;
            } else if(nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
    }
}

// naive solution
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                int j = i+1;
                for(;j<nums.length;j++)
                {
                    if(nums[j] != target)
                        break;
                }
                j--;
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        
        return result;
    }
}




