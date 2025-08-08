class Solution {
    public void f(int i, int[] nums, int sum, int target, List<Integer> arr, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }

        if(sum>target || i>=nums.length){
            return;
        }

        for(int idx = i; idx<nums.length; idx++){
            if(idx>i && nums[idx] == nums[idx-1]) continue;

            arr.add(nums[idx]);
            f(idx+1, nums, sum+nums[idx], target, arr, res);
            arr.remove(arr.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        f(0, candidates, 0, target, arr, res);
        return res;
    }
}