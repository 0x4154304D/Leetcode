//1
class Solution {
    public int mySqrt(int x) {
        long i = 0;
        while (i * i <= x) {
            ++i;
        }
        return (int) i - 1;
    }
}

// 2
class Solution {
    public int mySqrt(int x) {
        int l = 1, h = x;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m > x / m) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return h;
    }
}

// 3 Newton 
class Solution {
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}