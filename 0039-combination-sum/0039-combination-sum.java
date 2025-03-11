class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void comb(int[] candidates, int idx, int sum, List<Integer> arr, int target){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(sum > target || idx == candidates.length){
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            arr.add(candidates[i]);
            comb(candidates, i, sum+candidates[i], arr, target);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        comb(candidates, 0, 0, arr, target);
        return res;
    }
}