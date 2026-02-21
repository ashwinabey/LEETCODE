class Solution {

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;  
        }

        
        ListNode p2 = reverseLL(slow);
        ListNode p1 = head;

        int max = 0;

        
        while (p2 != null) {
            int candidate = p1.val + p2.val;
            max = Math.max(max, candidate);

            p1 = p1.next;
            p2 = p2.next;
        }

        return max;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}