 

/*
 
 given two linkedlist, each one represent a number.
 each digit in one number is stored in reverse. MSBs store at tail while LSBs store at head. 
 Calculate the sum of them. 
 
 Input: (2->4->3) + (5->6->4)
 Output: 7->0->8
 
 */


// for each List, use a pointer to scan each element
// everytime determine if this node is empty
// calculate sum and carry for each digit
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry =0;
 
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);
 
        return newHead.next;
    }