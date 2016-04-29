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
 		// we suppose that both p,q exist in this tree,
 		// if root equals any one of p, q, then root would be LCA
 		if(root == null || root == p || root == q) {
 			return root;
 		}

 		// divide
 			TreeNode left = lowestCommonAncestor(root.left, p, q);
 			TreeNode right = lowestCommonAncestor(root.right, p, q);
 			// left and right both non-null: left has p, right has q
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



// traditional method if the each TreeNode can access its parent
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
    	List<TreeNode> path_p = getPath2Root(root, p);
    	List<TreeNode> path_q = getPath2Root(root, q);

        for(int i = path_p.size() - 1, j = path_q.size() - 1; i >= 0 && j >= 0; --i, --j) {
            if(path_p.get(i) != path_q.get(j)) {
                return path_p.get(i).parent;
            }
        }
        return path_p.get(i+1);
    }

    public List<TreeNode> getPath2Root(TreeNode root, TreeNode node) {
    	List<TreeNode> path = new ArrayList<TreeNode>();
    	if(root == null) {
    		return path;
    	}

    	TreeNode p = node;
    	while(p != null) {
    		path.add(p);
    		p = p.parent;
    	}
    	return path;
    }


}

