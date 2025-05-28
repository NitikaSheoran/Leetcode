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
        int res = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            res++;
        }
        return res;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        int len = len(head);
        int mid = len/2;
        while(mid!=0){
            stack.push(temp.val);
            temp=temp.next;
            mid--;
        }
        if(len%2 == 1){
            temp=temp.next;
        }
        while(!stack.isEmpty()){
            int data = stack.pop();
            if(data != temp.val){
                return false;
            }else{
                temp = temp.next;
            }
        }
        return true;
    }
}