class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return root;
    }
}