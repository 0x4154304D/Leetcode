class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        int right = -1;
        for (int i = 0; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                right = i;
            } else {
                break;
            }
        }
        dfs(candidates, 0, right, target, path, res);
        return res;
    }

    public static void dfs(int[] nums, int left, int right, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = left; i <= right; ++i) {
            if (target - nums[i] < 0) {
                break;
            }
            path.addLast(nums[i]);
            dfs(nums, i + 1, right, target - nums[i], path, res);
            path.removeLast();
            while (i + 1 <= right && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
}