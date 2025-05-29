class Solution {
    public void sub(int[] nums, int i, List<List<Integer>> res, List<Integer> arr){
        if(i == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        sub(nums, i+1, res, arr);
        arr.remove(arr.size()-1);
        sub(nums, i+1, res, arr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        sub(nums, 0, res, arr);
        return res;
    }
}