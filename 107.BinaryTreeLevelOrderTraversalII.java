
/*
just like 102.BinaryTreeLevelOrderTraversal, traverse from top to bottom
each time adding a level to result, add it at the front position of List

add(0, level)

*/

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null) {
			return result;
		}

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

		while(!queue.isEmpty()) {
			List<Integer> curRes = new ArrayList<Integer>();
			int size = queue.size();
			for(int i = 0; i < size; ++i) {
				TreeNode temp = queue.poll();
				curRes.add(temp.val);
				
				if(temp.left != null) {
					queue.offer(temp.left);
				}

				if(temp.right != null) {
					queue.offer(temp.right);
				}
			}

			result.add(curRes);
		}

		return result;
    }

} 