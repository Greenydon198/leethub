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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null|| k==0)return head;
        ListNode c = head;
        while(c.next!=null)
            c=c.next;
        int l = size(head);
        c.next=head;
        k%=l;
        for(int i=1;i<l-k;i++){
            head=head.next;
        }
        ListNode t = head.next;
        head.next=null;
        return t;
    }
    int size(ListNode head){
        int l=0;
        while(head!=null){
            head=head.next;
            l++;
        }
        return l;
    }
}