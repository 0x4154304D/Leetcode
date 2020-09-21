class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length * nums2.length == 0)
            return;
        for (int i = 0; i < n; ++i) {
            nums1[m + i] = nums2[i];
        }
        for (int i = 0; i < n + m; ++i) {
            boolean flag = true;
            for (int j = 1; j < n + m - i; ++j) {
                if (nums1[j - 1] > nums1[j]) {
                    int tmp = nums1[j - 1];
                    nums1[j - 1] = nums1[j];
                    nums1[j] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}

// two Point
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}