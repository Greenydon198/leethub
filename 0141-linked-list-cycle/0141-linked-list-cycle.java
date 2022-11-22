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
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode fast = head.next;
        ListNode slow = head;
        boolean flag = true;
        while(fast!=slow){
            if(slow==null || fast==null || fast.next== null){
                flag = false;
                break;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return flag;
    }
}