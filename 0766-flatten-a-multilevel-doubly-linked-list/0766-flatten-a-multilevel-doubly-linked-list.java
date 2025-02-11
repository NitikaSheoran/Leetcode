/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        Node temp = head;
        while(temp.next != null || temp.child!=null){
            Node x = temp;
            Node y = temp.next;
            if(temp.child != null){
                temp.child.prev=temp;
                temp.next = temp.child;
                temp.child = null;

                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = y;
                if(y!=null){
                    y.prev=temp;
                }
            }
            temp = x;
            temp = temp.next;
        }
        return head;
    }
}