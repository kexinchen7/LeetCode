// non-recursion

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if(root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while(!stack.empty()) {
			TreeNode node = stack.pop();
			result.add(node.val);

			if(node.right != null) {
				stack.push(node.right);
			}

			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}
}


/*
	pre-order, traverse

*/
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		preorderTraversal(root, result);
		return result;
	}

	public void preorderTraversal(TreeNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		// root - left - right
		result.add(root.val);
		preorderTraversal(root.left, result);
		preorderTraversal(root.right, result);
	}
}

/*
	pre-order, divide and conquer

*/
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> result = new ArrayList<Integer>();
		// node or leaf ?
		if(root == null) {
			return result;
		}

		// divide
		List<Integer> left  = preorderTraversal(root.left);
		List<Integer> right = preorderTraversal(root.right);

		// conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);

		return result;
	}

}