class MinStack {
    private Stack<Integer> baseStack;
    private Stack<Integer> minStack;

    public MinStack() {
        baseStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        baseStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        baseStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return baseStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
