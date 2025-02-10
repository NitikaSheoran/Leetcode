class MedianFinder {
    ArrayList<Integer> arr;
    PriorityQueue<Double> g;
    PriorityQueue<Double> s;
    public MedianFinder() {
        arr = new ArrayList<>();
        g = new PriorityQueue<>();
        s = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
        s.add(-1.0 * num);
        g.add(-1.0 * s.poll());
        if (g.size() > s.size())
            s.add(-1.0 * g.poll());
    }
    
    public double findMedian() {
        if (g.size() != s.size())
            return -1.0 * s.peek();
        else
            return ((g.peek() - s.peek())/ 2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */