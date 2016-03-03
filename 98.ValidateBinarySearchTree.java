/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// by the property of in-order traversal

// firstNode is used to skip the "if(!firstNode && lastVal >= root.val){}" when the first enter
public class Solution {
    
    private boolean firstNode = true;
    private int lastVal;
    
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        
        if(!isValidBST(root.left)) {
            return false;
        }
        
        if(!firstNode && lastVal >= root.val) {
            return false;
        }
        
        firstNode = false;
        lastVal = root.val;
        
        if(!isValidBST(root.right)) {
            return false;
        }
        
        return true;
        
    }
    
    
}


// divide and conquer
class ReturnType {
    boolean isBst;
    int maxValue;
    int minValue;

    ReturnType(boolean is_Bst, int max_Value, int min_Value) {
        isBst = is_Bst;
        maxValue = max_Value;
        minValue = min_Value;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        ReturnType r = helper(root);
        return r.isBst;
    }

    public ReturnType helper(TreeNode root) {
        if(root == null) {
            return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        // divide
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        // conquer
        // any side return false
        if(!left.isBst || !right.isBst) {
            return new ReturnType(false, 0, 0);
        }

        // both sides return true, 
        // but when add root, one of sides doesn't satisfy
        if(root.left != null && root.val <= left.maxValue || 
           root.right != null && root.val >= right.minValue) {
            return new ReturnType(false, 0 , 0);
        }

        // both sides return true,
        // and when add root, both satisfy
        // be careful when the root doesn't have two childs, i.e. one child or no child
        return new ReturnType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }

}


