class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public void comb(List<Integer> arr, int[] nums, int i){
        if(i==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        comb(arr, nums, i+1);
        arr.remove(arr.size()-1);
        comb(arr, nums, i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        comb(arr, nums, 0);
        return res;
    }
}