//1
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int tmp : nums) {
            if (evenNum(tmp)) {
                ++res;
            }
        }
        return res;
    }

    static boolean evenNum(int num) {
        int res = 0;
        while (num != 0) {
            ++res;
            num /= 10;
        }
        return res % 2 == 0 ? true : false;
    }
}

// 2
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int tmp : nums) {
            if (tmp == 0 || (tmp > 9 && tmp < 100) || (tmp > 999 && tmp < 10000) || tmp == 100000) {
                ++res;
            }
        }
        return res;
    }
}