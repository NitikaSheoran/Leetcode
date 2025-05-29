class Solution {
    public void comb(int[] nums, int i, int sum, int target, List<List<Integer>> res, List<Integer> arr){
        if(sum == target){
            res.add(new ArrayList<>(arr));
            return;
        }

        if(sum > target){
            return;
        }

        for(int index = i; index<nums.length; index++){
            if(index > i && nums[index] == nums[index-1]) continue;

            arr.add(nums[index]);
            comb(nums, index+1, sum+nums[index], target, res, arr);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        comb(candidates, 0, 0, target, res, arr);
        return res;
    }
}