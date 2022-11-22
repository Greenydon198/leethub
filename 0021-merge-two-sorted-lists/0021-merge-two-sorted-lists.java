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
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1==null)return h2;
        if(h2==null)return h1;
        ListNode c=h1;
        ListNode cc=h2;
        while(c!=null|| cc!=null){
            if(c==null|| (cc!=null && c.val>=cc.val)){
                add(cc.val);
                cc=cc.next;
            }
            else if(cc==null || (c!=null&&c.val<=cc.val)){
                add(c.val);
                c=c.next;
            }
        }
        return h;
    }
    ListNode h;
    ListNode t;
    public void add(int d){
        ListNode nn = new ListNode(d);
        if(h==null){
            h=nn;
            t=nn;
        }
        else{
            t.next=nn;
            t=nn;
        }
    }
}