// 减枝加速
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int index = -1;
        for (int i = 0; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                index = i;
            } else {
                break;
            }
        }
        Deque<Integer> path = new ArrayDeque<>();
        helper(candidates, 0, index, target, path, res);
        return res;
    }

    public void helper(int[] nums, int left, int right, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = left; i <= right; ++i) {
            if (target - nums[i] < 0) {
                break;
            }
            path.addLast(nums[i]);
            helper(nums, i, right, target - nums[i], path, res);
            path.removeLast();
        }
    }
}