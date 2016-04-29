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
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	helper(root, result);
    	return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
    	if(root == null) {
    		return;
    	}
    	
    	if(root.left != null) {
    		helper(root.left, result);
    	}

    	result.add(root.val);

    	if(root.right != null) {
    		helper(root.right, result);
    	}
    }

}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        
        while(cur != null || !stack.empty()){
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.peek();
            stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

}


