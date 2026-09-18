class Solution {
    public void f(List<List<Integer>> res, List<Integer> arr, int idx, int[] nums){
        // if(idx == nums.length){
        //     res.add(new ArrayList(arr));
        //     return;
        // }
        res.add(new ArrayList(arr));

        // arr.add(nums[idx]);
        // f(res, arr, idx+1, nums);
        // arr.remove(arr.size()-1);
        // f(res, arr, idx+1, nums);
        for(int i = idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1]) continue;

            arr.add(nums[i]);
            f(res, arr, i+1, nums);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        f(res, arr, 0, nums);
        return res;
    }
}