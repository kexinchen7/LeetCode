/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// http://fmarss.blogspot.com/2014/08/leetcode-solution-sort-list.html
// solution 1: recursion
public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        
        while(runner.next!=null && runner.next.next!=null)
        {
            walker = walker.next;
            runner = runner.next.next;
        }
        
        ListNode head1 = walker.next;
        walker.next = null;
        // sort each half, then merge
        return merge(mergeSort(head), mergeSort(head1));
    }
    
    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead, p1 = l1, p2 = l2;
        while(p1!=null && p2!=null)
        {
            if(p1.val<p2.val)
            {
                p.next = p1;
                p1 = p1.next;
            }else
            {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        p.next = (p1==null) ? p2 : p1;
        return fakeHead.next;
    }
}

