    /*
        input 1->2->3->4->5,
        n=1, output 1->2->3->4
        n=5, output 2->3->4->5
     */

    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head==null)  return head;
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        // 0->1->2->3->4->5
        ListNode p = newHead;
        
        // get length
        int len = 0;
        while(p.next!=null)
        {
            len++;
            p = p.next;
        }
        // find the previous one near the target node
        p = newHead;
        int i=0;
        while(i!=len-n)
        {
            i++;
            p = p.next;
        }
        // determine where this node is
        // whether the target node is the last one or not
        if(p.next.next==null)
        {
            p.next = null;
        }
        else
        {
            p.next = p.next.next;
        }
        
        return newHead.next;
    }