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
    public int len(ListNode head){
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int len = len(head);
        k = k%len;
        if(k == 0){
            return head;
        }
        int x = len-k;
        ListNode temp = head;
        while(x>1){
            temp = temp.next;
            x--;
        }
        ListNode newHead = temp.next;
        ListNode dummyHead = temp.next;
        temp.next=null;
        while(dummyHead.next!=null){
            dummyHead = dummyHead.next;
        }
        dummyHead.next = head;
        head = newHead;
        return head;

    }
}