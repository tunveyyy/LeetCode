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
        
        if(head == null)
            return null;
        
        Node ptr = head;
        
        while(ptr != null) {
          
            Node clone = new Node(ptr.val);
            
            clone.next = ptr.next;
            ptr.next = clone;
            ptr = clone.next;
        }
        
        ptr = head;
        
        while(ptr != null) {
            
            ptr.next.random = ptr.random != null ? ptr.random.next: null;
            ptr = ptr.next.next;
            
        }
        Node old = head;
        Node clone = head.next;
        Node newHead = clone;

        while(old != null) {
            old.next = old.next.next;
            clone.next = clone.next != null ? clone.next.next: null;
            old = old.next;
            clone = clone.next;
        }
        return newHead;
    }
}