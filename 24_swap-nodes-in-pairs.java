class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode node1 = cur.next;
            if (node1.next == null)
                break;
            ListNode node2 = node1.next;
            ListNode tmp = node2.next;
            node2.next = node1;
            cur.next = node2;
            node1.next = tmp;
            cur = node1;
        }
        return dummy.next;
    }
}