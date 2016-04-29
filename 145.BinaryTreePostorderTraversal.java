public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
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


    	if(root.right != null) {
    		helper(root.right, result);
    	}
    	result.add(root.val);
    }
}


/*
		  8
	 6 		  9
  1	   7	10 11
   2
  3 4
      5

*/

// [8,6,9,1,7,10,11,null,2,null,null,null,null,null,null,3,4,null,null,null,5]
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        
        stack.push(root);
        
        while(!stack.empty()){
            cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur) {
                if(cur.left != null) {
                    stack.push(cur.left);
                } else if(cur.right != null) {
                    stack.push(cur.right);
                }
            } else if(cur.left == pre) {
                if(cur.right != null) {
                    stack.push(cur.right);    
                }
            } else {
                result.add(cur.val); 
                stack.pop();
            }
            pre = cur;
        }
        return result;
    }
}
