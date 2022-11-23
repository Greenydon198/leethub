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
    public void reorderList(ListNode head) {
        // int l = len(head);
        if(head==null || head.next==null||head.next.next==null)return;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        fast= slow.next;
        slow.next=null;
        ListNode c = null;
        ListNode p = null;
        while(fast!=null){
            c=fast.next;
            fast.next=p;
            p=fast;  
            fast=c;
        }
        while(head!=null && p!=null){
         ListNode tem = head.next;
            head.next=p;
            ListNode t2 = p.next;
            head.next.next=tem;
            p=t2;
            head=tem;
        }
    }
    // int len(ListNode head){
    //     int l = 0;
    //     while(head!=null){
    //         head=head.next;
    //         l++;
    //     }
    //     System.out.println(l);
    //     return l;
    // }
}