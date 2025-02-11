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
    public ListNode reverse(ListNode head){
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
    public int size(ListNode head){
        if(head==null){
            return 0;
        }
        ListNode temp = head;
        int count=1;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public int pairSum(ListNode head) {
        if(head==null || head.next==null){
            return -1;
        }
        if(head.next.next==null){
            return head.val + head.next.val;
        }
        ListNode temp = head;
        int n = size(temp);
        int[] arr = new int[n/2];
        for(int i=0; i<=(n/2)-1; i++){
            arr[i] = temp.val;
            temp = temp.next;
        }
        temp = reverse(head);
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<=(n/2)-1; i++){
            int sum = temp.val + arr[i];
            temp = temp.next;
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
        
    }
}