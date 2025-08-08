class Solution {
    public void f(int i, int[] nums, List<Integer> arr, List<List<Integer>> res){
       
        res.add(new ArrayList<>(arr));
           

        for(int idx=i; idx<nums.length; idx++){
            if(idx>i && nums[idx] == nums[idx-1]) continue;

            arr.add(nums[idx]);
            f(idx+1, nums, arr, res);
            arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        f(0, nums, arr, res);
        return res;
    }
}