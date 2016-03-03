/*

BFS: level searching

*/

// DFS depth-limted DFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
 		List<List<Integer>> results = new ArrayList<List<Integer>>();

 		if(root == null) {
 			return results;
 		}

 		int maxLevel = 0;
 		while(true) {
 			List<Integer> level = new ArrayList<Integer>();
 			dfs(root, level, 0, maxLevel);
 			if(level.size() == 0) {
 				break;
 			}
 			results.add(level);
 			maxLevel++;
 		}

 		return results;
    }

    private void dfs(TreeNode root, List<Integer> level, int curLevel, int maxLevel) {
    	if(root == null || curLevel > maxLevel) {
    		return;
    	}

    	if(curLevel == maxLevel) {
    		level.add(root.val);
    		return;
    	}

    	dfs(root.left, level, curLevel+1, maxLevel);
    	dfs(root.right, level, curLevel+1, maxLevel);
    }

} 


// BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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





// BFS with two queues - 1
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root == null) {
			return results;
		}

        List<TreeNode> Q1 = new ArrayList<TreeNode>();
        List<TreeNode> Q2 = new ArrayList<TreeNode>();

        Q1.add(root);
		List<Integer> level = new ArrayList<Integer>();

		while(Q1.size() != 0) {
		    
			TreeNode node = Q1.remove(0);
			level.add(node.val);

			if(node.left != null) {
				Q2.add(node.left);
			}

			if(node.right != null) {
				Q2.add(node.right);
			}
            
			if(Q1.size() == 0) {
				List<TreeNode> temp;
				temp = Q2;
				Q2 = Q1;
				Q1 = temp;

				results.add(level);
				level = new ArrayList<Integer>();
			}

		}

		return results;
	}

}


// BFS two queues - 2
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root == null) {
			return results;
		}

        List<TreeNode> Q1 = new ArrayList<TreeNode>();
        List<TreeNode> Q2 = new ArrayList<TreeNode>();

        Q1.add(root);
		
		while(Q1.size() != 0) {
		    List<Integer> level = new ArrayList<Integer>();
		    int size = Q1.size();
			for(int i = 0; i < size; i++) {
			    TreeNode node = Q1.remove(0);
			    level.add(node.val);
			    if(node.left != null) {
			        Q2.add(node.left);
			    }
			    
			    if(node.right != null) {
			        Q2.add(node.right);
			    }
			}
			
			results.add(level);
			List<TreeNode> temp;
			temp = Q2;
			Q2 = Q1;
			Q1 = temp;
		}

		return results;
	}

}



// BFS with dummy node
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root == null) {
			return results;
		}

        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        Q.offer(null);

        List<Integer> level = new ArrayList<Integer>();
		while(!Q.isEmpty()) {
			TreeNode node = Q.poll();
			if(node == null) {
				results.add(level);
				if(Q.isEmpty()) {
					break;
				}
				level = new ArrayList<Integer>();
				Q.offer(null);
				continue;
			}

			level.add(node.val);

			if(node.left != null) {
				Q.offer(node.left);
			}

			if(node.right != null) {
				Q.offer(node.right);
			}
		}

		return results;
	}

}