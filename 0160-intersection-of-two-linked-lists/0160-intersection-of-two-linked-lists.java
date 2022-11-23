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
        int hh = len(h);
        int hh1 = len(h1);
        int diff = Math.abs(hh-hh1);
        for(int i=1;i<=diff;i++){
            if(hh>hh1)
                h=h.next;
            else
                h1=h1.next;
        }
        while(h!=null){
            if(h==h1)
                return h;
            h=h.next;
            h1=h1.next;
        }
        return null;
    }
    int len(ListNode h){
        int i=0;
        while(h!=null){
            h=h.next;
            i++;
        }
        return i;
    }
}