class MinStack {
    private List<Integer> stack;
    private List<Integer> minNum;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minNum = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < min)
            min = x;
        stack.add(x);
        minNum.add(min);
    }

    public void pop() {
        minNum.remove(minNum.size() - 1);
        stack.remove(stack.size() - 1);
        if (stack.size() == 0)
            min = Integer.MAX_VALUE;
        else
            min = minNum.get(minNum.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minNum.get(minNum.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */