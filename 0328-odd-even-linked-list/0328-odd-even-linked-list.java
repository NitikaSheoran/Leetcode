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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode even = null;
        ListNode oddptr = odd;
        ListNode evenptr = even;
        ListNode temp = head;
        int count=1;
        while(temp!=null){
            if(count %2 == 0){
                if(even == null){
                    even = temp;
                    evenptr = even;
                }else{
                    evenptr.next = temp;
                    evenptr = evenptr.next;
                }
            }else{
                if(odd == null){
                    odd = temp;
                    oddptr = odd;
                }else{
                    oddptr.next = temp;
                    oddptr = oddptr.next;
                }
            }
            temp = temp.next;
            count++;
        }
        if(even == null){
            return odd;
        }
        if(odd == null){
            return even;
        }
        oddptr.next = even;
        evenptr.next=null;
        return odd;
    }
}