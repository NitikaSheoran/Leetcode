class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int n;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>();
        n=0;
    }
    
    public void addNum(int num) {
        n++;
        if(maxHeap.isEmpty() || maxHeap.size()<=minHeap.size()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            maxHeap.add(minHeap.poll());
        }
        
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        // System.out.println(n + "  " + maxHeap + "  " + minHeap);
        if(n%2 == 1){
            return maxHeap.peek();
        }else{
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */