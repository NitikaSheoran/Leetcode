class MyStack {
    Queue<Integer> queue;
    Queue<Integer> queue2;
    public MyStack() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        int n = queue.size();
        for(int i=0; i<n-1; i++){
            queue2.add(queue.poll());
        }
        int x = queue.poll();
        while(!queue2.isEmpty()){
            queue.add(queue2.poll());
        }
        return x;
    }
    
    public int top() {
        int n = queue.size();
        for(int i=0; i<n-1; i++){
            queue2.add(queue.poll());
        }
        int x = queue.peek();
        queue2.add(queue.poll());
        while(!queue2.isEmpty()){
            queue.add(queue2.poll());
        }
        return x;
    }
    
    public boolean empty() {
        return queue.isEmpty();
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