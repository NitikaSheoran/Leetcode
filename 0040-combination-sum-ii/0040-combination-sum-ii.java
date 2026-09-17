class Solution {
    public void f(List<List<Integer>> res, List<Integer> arr, int idx, int sum, int[] candidates, int target){
        if(sum == target){
            res.add(new ArrayList(arr));
            return;
        }
        if(sum > target) return;
        if(idx >= candidates.length) return;

        // arr.add(candidates[idx]);
        // f(res, arr, idx+1, sum+candidates[idx], candidates, target);
        // arr.remove(arr.size() -1);
        // f(res, arr, idx+1, sum, candidates, target);
        for(int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            arr.add(candidates[i]);
            f(res, arr, i+1, sum+candidates[i], candidates, target);
            arr.remove(arr.size() -1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        f(res, arr, 0, 0, candidates, target);
        return res;
    }
}