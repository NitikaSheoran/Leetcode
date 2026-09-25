class Solution {
    public void f(int i, List<Integer> arr, List<List<Integer>> res,boolean[] visited, int[] nums){
        if(arr.size() == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int idx=0; idx<nums.length; idx++){
            if(!visited[idx]){
                arr.add(nums[idx]);
                visited[idx] = true;
                f(i+1, arr, res, visited, nums);
                arr.remove(arr.size()-1);
                visited[idx] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        f(0, arr, res, visited, nums);
        return res;
    }
}