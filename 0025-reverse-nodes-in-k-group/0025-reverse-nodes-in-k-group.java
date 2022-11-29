/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)return head;
        ListNode t1 = new ListNode(-1,head);
        ListNode ans = t1;
        // t1.next=head;
        ListNode c = head;
        while(c!=null){
            ListNode h = c;
            int i=1;
            for(;i<k && c!=null;i++){
                c=c.next;
            }
            ListNode t=c;
            if(t==null)break;
            // ListNode t2 = c.next;
            c=c.next;
            // t.next=null;
            
            ListNode p = null;
            ListNode pp = h;
            ListNode f = h.next;
            while(pp!=c){
                pp.next=p;
                p=pp;pp=f;
                if(f!=null)
                f=f.next;
            }
            
            t1.next=t;
            h.next=c;
            // c=t2;
            t1=h;
            
        }
        return ans.next;
    }
}