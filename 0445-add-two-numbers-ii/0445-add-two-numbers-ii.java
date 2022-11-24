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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        // ListNode n;
        while(l1!=null && l2!=null){
            int s = l1.val+l2.val;
            add(s%10);
            if(s>9 && l1.next!=null)
                l1.next.val+=1;
            else if(s>9 && l2.next!=null)
                l2.next.val+=1;
            else if(s>9 && l1.next== null && l2.next==null)
                add(1);
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            add(l1.val%10);
            if(l1.val>9 && l1.next!=null){
                l1.next.val+=1;
            }
            else if(l1.val>9 && l1.next==null)
                add(1);
            l1=l1.next;
        }
        while(l2!=null){
            add(l2.val%10);
            if(l2.val>9 && l2.next!=null){
                l2.next.val+=1;
            }
            else if(l2.val>9 && l2.next==null)
                add(1);
            l2=l2.next;
        }
        return h;
    }
    ListNode h;
    ListNode t;
    void add(int d){
        ListNode nn = new ListNode(d);
        if(h==null){
            h=nn;
            t=nn;
        }
        else{
            nn.next=h;
            h=nn;
        }
    }
    ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode t = head.next;
        ListNode f = head.next.next;
        head.next=null;
        while(t!=null){
            t.next=head;
            head=t;
            t=f;
            if(f!=null)
            f=f.next;
        }
        return head;
    }
}