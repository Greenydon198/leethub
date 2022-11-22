/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        // boolean flag = true;
        while(fast!=slow){
            if(slow==null || fast==null || fast.next== null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}