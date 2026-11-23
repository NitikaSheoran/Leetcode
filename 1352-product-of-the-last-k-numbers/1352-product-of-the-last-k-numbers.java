class ProductOfNumbers {
    int n;
    ArrayList<Integer> prod;
    public ProductOfNumbers() {
        prod = new ArrayList<>();
        prod.add(1);
        n = 0;
    }
    
    public void add(int num) {
        if(num == 0){
            prod = new ArrayList<>();
            prod.add(1);
            n = 0;
        }else{
            prod.add(prod.get(n)*num);
            n++;
        }
        
    }
    
    public int getProduct(int k) {
        if(k>n) return 0;
        return prod.get(n)/prod.get(n-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */