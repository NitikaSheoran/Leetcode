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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        while(fast.next != null && fast.next.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null){
            stack.push(slow.val);
        }
        slow = slow.next;
        while(!stack.isEmpty() && slow != null){
            if(stack.pop() == slow.val){
                slow = slow.next;
            }else{
                return false;
            }
        }
        return true;
    }
}