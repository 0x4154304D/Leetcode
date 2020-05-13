//1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 0;
        boolean flag = false;
        for (i = 0; i < nums.length; ++i) {
            for (j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        int[] res = { i, j };
        return res;
    }
}

// 2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// 3
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
