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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null|| head.next==null)return null;
        int l=0;
        ListNode c = head;
        while(c!=null){
            c=c.next;
            l++;
        }
        // System.out.println(l);
        c=head;
        for(int i=1;i<l-n;i++){
            c=c.next;
        }
        if(l-n==0){
            return head.next;
        }
        else if(n==1){
            c.next=null;
            return head;
        }
        else{
            c.next= c.next.next;
            return head;
        }
    }
}