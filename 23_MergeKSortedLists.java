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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for(ListNode item: lists) {
            
            if(item != null)
                heap.add(item);
        }
        
        while(!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if(tail.next != null) {
                heap.add(tail.next);
            }
            
        }
        
        return dummy.next;
        
    }
}