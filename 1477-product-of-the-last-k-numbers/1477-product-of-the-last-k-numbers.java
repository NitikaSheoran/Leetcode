class ProductOfNumbers {
    List<Integer> arr;
    int size;
    public ProductOfNumbers() {
        size=0;
        arr = new ArrayList<Integer>();
        arr.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            arr = new ArrayList<>();
            arr.add(1);
            size=0;
        }else{
            arr.add(arr.get(size)*num);
            size++;
        }
    }
    
    public int getProduct(int k) {
        if(k>size) return 0;
        return(arr.get(size)/arr.get(size-k));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */