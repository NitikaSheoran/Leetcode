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
    public ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(head1 != null && head2 != null){
            if(head1.val >= head2.val){
                head.next = head2;
                head2 = head2.next;
            }else{
                head.next = head1;
                head1 = head1.next;
            }
            head = head.next;
        }
        if(head1 != null){
            head.next = head1;
        }
        if(head2 != null){
            head.next = head2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode res = null;
        for(int i=0; i<lists.length; i++){
            res = merge(res, lists[i]);
        }
        return res;
    }
}