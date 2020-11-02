public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode intersect = getIntersection(head);
        if (intersect == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = intersect;
        while (p1 != p2) {

            p1 = p1.next;
            p2 = p2.next;

        }
        return p1;

    }

    private ListNode getIntersection(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return fast;
        }
        // System.out.println(fast.val);
        return null;
    }
}