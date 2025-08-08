class Solution {
    public void f(int i, int[] nums, int sum, int target, List<Integer> arr, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }
        if(sum > target || i>=nums.length){
            return;
        }
        
        arr.add(nums[i]);
        f(i, nums, sum+nums[i], target, arr, res);
        arr.remove(arr.size()-1);
        f(i+1, nums, sum, target, arr, res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        f(0, candidates, 0, target, arr, res);
        return res;
    }
}