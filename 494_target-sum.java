//dfs
class Solution {
    int res;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0);
        return res;
    }

    private void dfs(int[] nums, int S, int i) {
        if (i == nums.length) {
            if (S == 0)
                ++res;
            return;
        }
        dfs(nums, S + nums[i], i + 1);
        dfs(nums, S - nums[i], i + 1);
    }
}