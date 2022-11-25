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
        ListNode c = l1;
        while(c!=null && l2!=null){
            int s = c.val+l2.val;
            c.val = s%10;
            if(s>9 && c.next!=null)
                c.next.val+=1;
            else if(s>9 && l2.next!=null)
                l2.next.val+=1;
            else if(s>9 && c.next==null && l2.next==null){
                ListNode nn = new ListNode(1);
                c.next=nn;
            }
            c= c.next;
            l2=l2.next;
        }
        while(c!=null){
            if(c.val>9 && c.next!=null){
                c.next.val+=1;
                c.val %=10;
            }
            else if(c.val>9){
                c.val%=10;
                ListNode nn = new ListNode(1);
                c.next=nn;
            }
            c=c.next;
        }
        c=l1;
        while(c.next!=null)
            c=c.next;
        while(l2!=null){
            if(l2.val>9 && l2.next!=null){
                l2.next.val+=1;
                ListNode nn = new ListNode(l2.val%10);
                c.next=nn;
                c=nn;
            }
            else if(l2.val>9){
                ListNode nnn = new ListNode(l2.val%10);
                c.next=nnn;
                c=nnn;
                ListNode nn = new ListNode(1);
                c.next=nn;
                c=nn;
            }
            else{
                ListNode nn = new ListNode(l2.val);
                c.next=nn;
                c=nn;
            }
            l2=l2.next;
        }
        return l1;
    }
}