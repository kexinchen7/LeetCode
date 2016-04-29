
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    /*
    singlePath: maximum from root to any node, 
                may contain 0 node if we don't include root node
    maxPath: maximum from any node to any node
    */
    private class ResultType {
        int singlePath;
        int maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    } 
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);        
        }
        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // update singlePath
        int singlePath = Math.max(left.singlePath, right.singlePath);
        singlePath = Math.max(singlePath + root.val, 0);
        // update maxPath
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }
    
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}