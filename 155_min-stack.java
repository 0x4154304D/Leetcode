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


 // 2
 class MinStack {

    private Stack<Integer> realStack;
    private Stack<Integer> assistStack;
    /** initialize your data structure here. */
    public MinStack() {
        realStack = new Stack<>();
        assistStack = new Stack<>();
    }
    
    public void push(int x) {
        realStack.push(x);
        if (assistStack.empty()) {
            assistStack.push(x);
        } else {
            x = x < assistStack.peek() ? x : assistStack.peek();
            assistStack.push(x);
        }
    }
    
    public void pop() {
        realStack.pop();
        assistStack.pop();
    }
    
    public int top() {
        return realStack.peek();
    }
    
    public int getMin() {
        return assistStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */