class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        int last = -1;
        while(!s1.isEmpty()){
            last = s1.pop();
            s2.push(last);
        }
        s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return last;
    }
    
    public int peek() {
        int last = -1;
        while(!s1.isEmpty()){
            last = s1.pop();
            s2.push(last);
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return last;
    }
    
    public boolean empty() {
        return s1.isEmpty();
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