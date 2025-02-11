/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp!=null){
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp!=null){
            Node copy = temp.next;
            if(temp.random!=null)
                copy.random = temp.random.next;
            temp = temp.next.next;
        }
        Node dummy = new Node(0);
        temp =head;
        Node temp1 = dummy;
        while(temp!=null){
            temp1.next = temp.next;
            temp.next = temp.next.next;
            temp1 = temp1.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}