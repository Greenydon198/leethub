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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return head;
        ListNode o=head;
        ListNode e=head.next;
        ListNode ee=head.next;
        while(o.next!=null && o.next.next!=null){
            o.next=o.next.next;
            if(o.next.next!=null){    
                e.next=o.next.next;
                e=e.next;
            }
            o=o.next;
        }
        e.next=null;
        o.next=ee;
        return head;
    }
}