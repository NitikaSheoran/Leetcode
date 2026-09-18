class Solution {
    public void f(List<List<Integer>> res, List<Integer> arr, int sum, int i, int n, int k){
        if(arr.size() == k && sum == n){
            res.add(new ArrayList(arr));
            return;
        }
        if(i >= 10) return;
        if(sum>n) return;
        if(arr.size() > k) return;

        arr.add(i);
        f(res, arr, sum+i, i+1, n, k);
        arr.remove(arr.size()-1);
        f(res, arr, sum, i+1, n, k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        f(res, arr, 0, 1, n, k);
        return res;
    }
}