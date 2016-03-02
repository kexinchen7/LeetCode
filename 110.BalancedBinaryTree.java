

public class Solution {
	public boolean isBalanced(TreeNode root) {
		return maxDepth(root) != -1;
	}

	private int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left  = maxDepth(root.left);
		int right = maxDepth(root.right);

		if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}

// todo: difference between static and private method



// method 2
class ResultType {
	public boolean isBalanced;
	public int maxDepth;
	public ResultType(boolean isBalanced, int maxDepth) {
		this.isBalanced = isBalanced;
		this.maxDepth = maxDepth;
	}
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		return helper(root).isBalanced;
	}

	public ResultType helper(TreeNode root) {
		if(root == null) {
			return new ResultType(true, 0);
		}

		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		if(!left.isBalanced || !right.isBalanced) {
			return new ResultType(false, -1);
		}

		if(Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new ResultType(false, -1);
		}

		return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
	}
}