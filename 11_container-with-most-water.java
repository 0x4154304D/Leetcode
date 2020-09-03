class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return -1;
        int ans = -1;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int hi = height[left] > height[right] ? height[right--] : height[left++];
            ans = (hi * (right - left + 1)) > ans ? (hi * (right - left + 1)) : ans;
        }
        return ans;
    }
}