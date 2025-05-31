class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int last = -1;
        while(!q1.isEmpty()){
            last = q1.poll();
            q2.add(last);
        }
        while(q2.size()>1){
            q1.add(q2.poll());
        }
        q2.poll();
        return last;
    }
    
    public int top() {
        int last = -1;
        while(!q1.isEmpty()){
            last = q1.poll();
            q2.add(last);
        }
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return last;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */