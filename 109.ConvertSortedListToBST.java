/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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

	static ListNode index; 

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)	return null;
        // get length
        int len = 0;

        ListNode p = head;
        while(p!=null)
        {
        	len++;
        	p=p.next;
        }

        index = head;

        return sortedListToBST(0, len-1);
    }

    public TreeNode sortedListToBST(int l, int r)
    {
    	if(l>r)	return null;

    	int mid = l+(r-l)/2;

    	TreeNode left = sortedListToBST(l, mid-1);
    	TreeNode root = new TreeNode(index.val);
    	index = index.next;
    	TreeNode right = sortedListToBST(mid+1, r);

    	root.left = left;
    	root.right = right;
    	return root;
    }
}