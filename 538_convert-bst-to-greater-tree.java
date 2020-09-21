//1
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> treeNode = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            treeNode.add(cur.val);
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        int[] arr = new int[treeNode.size()];
        for (int i = 0; i < treeNode.size(); ++i) {
            arr[i] = treeNode.get(i);
        }
        Arrays.sort(arr);
        int[] sum = new int[arr.length];
        sum[arr.length - 1] = 0;
        for (int i = arr.length - 2; i > -1; --i) {
            if (arr[i] < arr[i + 1]) {
                sum[i] = sum[i + 1] + arr[i + 1];
            } else {
                sum[i] = sum[i + 1];
            }
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            for (int i = arr.length - 1; i > -1; --i) {
                if (arr[i] <= cur.val) {
                    cur.val += sum[i];
                    break;
                }
            }
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        return root;
    }
}

// Recursion
class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}

// Morris
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}