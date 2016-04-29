/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	// private variables
	private TreeNode cur;
	private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur != null || !stack.empty());
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }

        cur = stack.pop();
        int smallest = cur.val;
        cur = cur.right;
        return smallest;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */