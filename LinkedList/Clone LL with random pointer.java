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
        Node temp=head;
        while(temp!=null){
            Node next=temp.next;
            Node copy=new Node(temp.val);
            temp.next=copy;
            copy.next=next;
            temp=next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random=temp.random.next;
            temp=temp.next.next;
        }
        temp=head;
        Node newHead=new Node(0);
        Node node=newHead;
        while(temp!=null){
            node.next=temp.next;
            
            temp.next=temp.next.next;
            temp=temp.next;
            node=node.next;
        }
        return newHead.next;
    }
}
