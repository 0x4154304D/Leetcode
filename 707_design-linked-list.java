//Define ListNode
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// Singly Linked List
class MyLinkedList {
    private int size;
    // sentinel nodes as pseudo-head and pseudo-tail
    private ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size)
            return -1;

        // choose the fastest way: to move from the head
        // or to move from the tail
        ListNode cur = head.next;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size)
            return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0)
            index = 0;

        // find predecessor and successor of the node to be added
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        ++size;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size)
            return;
        ListNode cur = head;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        ListNode tmp = cur.next;
        cur.next = tmp.next;
        --size;
    }
}

/*************************************************** */
// 双向链表
public class ListNode {
    int val;
    ListNode next;
    ListNode pre;

    ListNode(int x) {
        val = x;
    }
}

class MyLinkedList {
    private int size;
    ListNode head, tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode cur = head.next;
        if (index * 2 < size) {
            for (int i = 0; i < index; ++i) {
                cur = cur.next;
            }
        } else {
            cur = tail.pre;
            for (int i = 0; i < size - index - 1; ++i) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index < 0)
            index = 0;
        ListNode newNode = new ListNode(val);
        if (index * 2 < size) {
            ListNode cur = head;
            for (int i = 0; i < index; ++i) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            newNode.pre = cur;
            cur.next.pre = newNode;
            cur.next = newNode;
        } else {
            ListNode cur = tail;
            for (int i = 0; i < size - index; ++i) {
                cur = cur.pre;
            }
            newNode.pre = cur.pre;
            newNode.next = cur;
            cur.pre.next = newNode;
            cur.pre = newNode;
        }
        ++size;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (index * 2 < size) {
            ListNode cur = head;
            for (int i = 0; i < index; ++i) {
                cur = cur.next;
            }
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next.pre = cur;
        } else {
            ListNode cur = tail;
            for (int i = 0; i < size - index; ++i) {
                cur = cur.pre;
            }
            cur.next.pre = cur.pre;
            cur.pre.next = cur.next;
        }
        --size;
    }
}