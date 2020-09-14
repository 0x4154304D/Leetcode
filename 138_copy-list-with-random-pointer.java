//brute
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node dummy = new Node(0);
        Node curNewList = dummy;
        Node curOldList = head;
        while (curOldList != null) {
            Node newNode = new Node(curOldList.val);
            curNewList.next = newNode;
            curNewList = curNewList.next;
            curOldList = curOldList.next;
        }
        curOldList = head;
        curNewList = dummy.next;
        while (curOldList != null) {
            if (curOldList.random == null) {
                curNewList.random = null;
            } else {
                Node cur = head;
                Node tmp = dummy.next;
                while (cur != curOldList.random) {
                    cur = cur.next;
                    tmp = tmp.next;
                }
                curNewList.random = tmp;
            }
            curNewList = curNewList.next;
            curOldList = curOldList.next;
        }
        return dummy.next;
    }
}

// 回溯
public class Solution {
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the
        // cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val, null, null);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would
        // help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next
        // pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}