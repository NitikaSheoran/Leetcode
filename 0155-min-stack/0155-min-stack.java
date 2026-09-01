class MinStack {
    Stack<Integer> s;
    Stack<Integer> minS;
    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int value) {
        s.push(value);
        if(minS.isEmpty() || minS.peek() >= value){
            minS.push(value);
        }
        
    }
    
    public void pop() {
        if(minS.peek().equals(s.peek())){
            minS.pop();
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */