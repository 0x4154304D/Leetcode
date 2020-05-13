//1
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] count = new int[61];
        for (int tmp : time) {
            ++count[tmp % 60];
        }
        for (int i = 0; i <= 30; ++i) {
            if (i == 0 || i == 30) {
                res += (count[i] * (count[i] - 1)) / 2;
            } else {
                res += count[i] * count[60 - i];
            }
        }
        return res;
    }
}

// 2
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int cp = 0;
        int[] map = new int[60];
        for (int value : time) {
            int remainder = value % 60;
            cp += map[remainder];
            int target = remainder == 0 ? 0 : 60 - remainder;
            map[target]++;
        }
        return cp;
    }
}