/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode h, ListNode h1) {
        if(h==null || h1==null)return null;
        ListNode flag = null;
        ListNode c= h1;
        while(h!=null){
            c=h1;
            while(c!=null){
                if(h==c)
                    return c;
                c=c.next;
            }
            h=h.next;
        }
        return flag;
    }
}