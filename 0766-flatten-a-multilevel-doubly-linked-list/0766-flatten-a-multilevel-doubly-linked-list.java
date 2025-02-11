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
        int i=0;
        while(temp.next != null || temp.child!=null){
            Node x = temp;
            Node y = temp.next;
            // System.out.println("iteration "+i + " x.val = "+x.val + "x.next = "+ y.val);
            i++;
            if(temp.child != null){
                // System.out.println("child found at node value : "+temp.val +" child = "+temp.child.val);
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
            // System.out.println("list updated: ");
            temp = x;
            temp = temp.next;
        }
        // System.out.println("final ll: ");
        temp=head;
        while(temp!=null){
            System.out.print(temp.val + "  ");
            temp=temp.next;
        }
        return head;
    }
}