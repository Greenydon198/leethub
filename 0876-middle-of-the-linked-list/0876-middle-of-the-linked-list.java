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
    public ListNode middleNode(ListNode head) {
        int n = size(head);
        if(n==0)return null;
        ListNode c = head;
        for(int i=1;i<=(int)(Math.ceil(n/2));i++){
            c=c.next;
        }
        return c;
    }
    public int size(ListNode head){
        if(head==null)return 0;
        ListNode c = head;
        int i=0;
        while(c!=null){
            c=c.next;
            i++;
        }
        // System.out.println(i);
        return i;
    }
}