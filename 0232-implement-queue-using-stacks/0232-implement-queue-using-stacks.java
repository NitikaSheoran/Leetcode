class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> stack2;
    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        int n = stack.size();
        for(int i=0; i<n-1; i++){
            stack2.push(stack.pop());
        }
        int x = stack.pop();
        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
        return x;
    }
    
    public int peek() {
        int n = stack.size();
        for(int i=0; i<n-1; i++){
            stack2.push(stack.pop());
        }
        int x = stack.peek();
        stack2.push(stack.pop());
        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
        return x;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */