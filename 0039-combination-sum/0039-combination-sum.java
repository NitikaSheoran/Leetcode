class Solution {
    public void f(int i, int sum, List<Integer> arr, List<List<Integer>> res, int[] candidates, int target){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(i>=candidates.length) return;
        if(sum>target) return;


        arr.add(candidates[i]);
        f(i, sum+candidates[i], arr, res, candidates, target);

        arr.remove(arr.size()-1);
        f(i+1, sum, arr, res, candidates, target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        f(0, 0, arr, res, candidates, target);
        return res;
    }
}