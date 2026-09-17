class Solution {
    public void f(List<List<Integer>> res, List<Integer> arr, int idx, int sum, int[] candidates, int target){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(idx >= candidates.length) return;
        if(sum > target) return;

        arr.add(candidates[idx]);
        f(res, arr, idx, sum+candidates[idx], candidates, target);
        arr.remove(arr.size()-1);
        f(res, arr, idx+1, sum, candidates, target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        f(res, arr, 0, 0, candidates, target);
        return res;
    }
}