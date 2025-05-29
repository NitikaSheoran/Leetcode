class Solution {
    public void comb(int[] nums, int i, int sum, int target, List<List<Integer>> res, List<Integer> arr){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(i == nums.length || sum>target){
            return;
        }
        
        arr.add(nums[i]);
        comb(nums, i, sum+nums[i], target, res, arr);
        
        arr.remove(arr.size()-1);
        comb(nums, i+1, sum, target, res, arr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        comb(candidates, 0, 0, target, res, arr);
        return res;
    }
}