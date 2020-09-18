class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return head;
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node curr = cur.child;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = cur.next;
                if (cur.next != null)
                    cur.next.prev = curr;
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }
}