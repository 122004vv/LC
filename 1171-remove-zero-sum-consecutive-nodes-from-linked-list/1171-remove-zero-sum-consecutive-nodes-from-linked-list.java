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
    public ListNode removeZeroSumSublists(ListNode head) {
        int s=0;
        ListNode in=new ListNode(0);
        in.next=head;
        Map<Integer,ListNode> mp=new HashMap();
        for(ListNode i=in;i!=null;i=i.next){
            s+=i.val;
            mp.put(s,i);
        }
        s=0;
        for(ListNode i=in;i!=null;i=i.next){
            s+=i.val;
            i.next=mp.get(s).next;
        }
        return in.next;
    }
}