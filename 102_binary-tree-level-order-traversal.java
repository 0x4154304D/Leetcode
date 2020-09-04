class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> curLevel = new LinkedList<>();
            TreeNode node = queue.poll();
            ArrayList<Integer> cur = new ArrayList<>();
            while (node != null) {
                cur.add(node.val);
                if (node.left != null) {
                    curLevel.offer(node.left);
                }
                if (node.right != null) {
                    curLevel.offer(node.right);
                }
                node = queue.poll();
            }
            queue = curLevel;
            res.add(cur);
        }
        return res;
    }
}