//Array
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int len1 = sizeOfList(l1);
        int len2 = sizeOfList(l2);
        ListNode cur1 = l1, cur2 = l2;
        int index = len1 - len2;
        int[] arr = new int[len1 > len2 ? len1 + 1 : len2 + 1];
        int i = 1;
        if (index > 0) {
            for (; i <= index; ++i) {
                arr[i] = cur1.val;
                cur1 = cur1.next;
            }
        } else {
            index = 0 - index;
            for (; i <= index; ++i) {
                arr[i] = cur2.val;
                cur2 = cur2.next;
            }
        }
        for (; i < arr.length; ++i) {
            arr[i] = cur1.val + cur2.val;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode dummy = new ListNode(0);
        int carry = 0;
        for (i = arr.length - 1; i > 0; --i) {
            ListNode newNode = new ListNode((arr[i] + carry) % 10);
            carry = (arr[i] + carry) / 10;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        arr[0] += carry;
        if (arr[0] == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummy.next;
            return newNode;
        }
        return dummy.next;
    }

    public static int sizeOfList(ListNode l1) {
        ListNode cur = l1;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            ++size;
        }
        return size;
    }
}

// Stack
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }
}