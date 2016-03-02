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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
 		if(root == null || root == p || root == q) {
 			return root;
 			// if root == null, return null, means that the root node doesn't have both
 			// if root == p, suppose q exist, q.val > p.val, q is on the right substree of p
 			// if root == q, suppost p exist, p.val < q.val, p is on the left subtree of q
 		}

 		// divide
 			TreeNode left = lowestCommonAncestor(root.left, p, q);
 			TreeNode right = lowestCommonAncestor(root.right, p, q);
 			// left an right both non-null: left has p, right has q
 			if(left != null && right != null) {
 				return root;
 			}
 			// left has p, but right doesn't have q
 			if(left != null) {
 				return left;
 			}
 			// right has q, but left doesn't have p
 			if(right != null) {
 				return right;
 			}
 			// no p and no q 
 			return null;
    }
}