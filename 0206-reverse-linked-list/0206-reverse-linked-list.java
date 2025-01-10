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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head.next;
        head.next = null;
        ListNode x = temp.next;
        while(x != null){
            temp.next = head;
            head = temp;
            temp = x;
            x = x.next;
        }
        temp.next = head;
        head = temp;
        return head;
    }
}