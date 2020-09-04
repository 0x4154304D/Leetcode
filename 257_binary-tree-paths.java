// Recursion
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        helper(root, "", ans);
        return ans;
    }
    public void helper (TreeNode root, String cur, List<String> ans){
        StringBuilder tmp = new StringBuilder(cur);
        tmp.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(tmp.toString());
            return ;
        }
        tmp.append("->");
        if (root.left != null) {
            helper(root.left, tmp.toString(), ans);
        }
        if (root.right != null) {
            helper(root.right, tmp.toString(), ans);
        }
    }
}