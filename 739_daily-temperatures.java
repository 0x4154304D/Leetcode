// Stack
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < T.length; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int peek = stack.pop();
                res[peek] = i - peek;
            }
            stack.push(i);
        }
        return res;
    }
}

// 数组 模拟栈
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int[] stack = new int[T.length];
        int i = -1;
        int j = 0;
        while (j < T.length) {
            while (i >= 0 && T[stack[i]] < T[j]) {
                result[stack[i]] = j - stack[i];
                i--;
            }
            stack[++i] = j++;
        }
        return result;
    }
}