class Solution {
    public void f(int i, int[] nums, List<Integer> arr, List<List<Integer>> res, Set<Integer> seen){
        if(arr.size() == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int idx=0; idx<nums.length; idx++){
            if(seen.contains(nums[idx])) continue;

            seen.add(nums[idx]);
            arr.add(nums[idx]);
            f(idx+1, nums, arr, res, seen);
            seen.remove(nums[idx]);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        f(0, nums, arr, res, seen);
        return res;
    }
}