/*
 the key to solve this problem is to use an empty head
 */

 public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode p1=l1, p2=l2;
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        
        while(p1!=null && p2!=null)
        {
            if(p1.val<=p2.val)
            {
                p.next = p1;
                p1 = p1.next;
            }
            else
            {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // append the remaing of the longer list
        p.next = (p1==null)? p2 : p1;
        return fakeHead.next;
    }
}