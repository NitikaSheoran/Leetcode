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
    public int len(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        ListNode temp=new ListNode(0);
        ListNode head = new ListNode(0);
        int skip = 0;
        if(lenA > lenB){
            skip = lenA-lenB;
            temp = headA;
            head = headB;
        }else{
            skip = lenB-lenA;
            temp = headB;
            head = headA;
        }
        while(skip!=0){
            temp = temp.next;
            skip--;
        }
        int x = Math.min(lenA,lenB);
        while(x!=0){
            if(temp == head){
                return temp;
            }
            temp = temp.next;
            head = head.next;
            x--;
        }
        return null;
    }
}