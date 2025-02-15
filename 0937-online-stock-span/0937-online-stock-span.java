class StockSpanner {
    Stack<int[]> main;
    public StockSpanner() {
        main = new Stack<>();
    }
    
    public int next(int price) {
        int days=1;
        while(!main.isEmpty() && main.peek()[0]<=price){
            days += main.pop()[1];
        }
        main.push(new int[]{price, days});
        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */