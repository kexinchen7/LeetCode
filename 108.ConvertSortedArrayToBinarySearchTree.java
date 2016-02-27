/*
 convert a sorted array to a balanced BST

 keep dividing the numbers into halves, until in each half there are only two or three numbers;

 two situations
 1. three numbers:

 1 2 3 ->

   1
 2   3

 2. two numbers:
 1 2 ->

    1
null  2

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
        	return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r)
    {
    	if(l>r)	return null;

    	int mid = l+(r-l)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = sortedArrayToBST(nums, l, mid-1);
    	root.right= sortedArrayToBST(nums, mid+1, r);
    	return root;
    }
}