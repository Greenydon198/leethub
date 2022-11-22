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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode c = head.next;
        ListNode p = head;
        // ListNode cc=head.next;
        // ListNode pp = head;
        head.next=null;
        while(c!=null){
            ListNode cc=c.next;
            ListNode pp =c;
           c.next=p;
            c=cc;
            p=pp;
        }
        return p;
    }
}