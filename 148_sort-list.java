//PriorityQueue
class Solution {
    public ListNode sortList(ListNode head) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        ListNode cur = head;
        while (cur != null) {
            pq.offer(cur);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        cur = dummy;
        while (!pq.isEmpty()) {
            ListNode newNode = pq.poll();
            cur.next = newNode;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}

// MergeSort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newNode = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(newNode);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }
}