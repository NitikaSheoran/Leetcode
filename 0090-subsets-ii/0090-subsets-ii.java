import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void subset(int[] nums, int idx, List<Integer> arr) {
        res.add(new ArrayList<>(arr));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue; 
            
            arr.add(nums[i]);
            subset(nums, i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        subset(nums, 0, new ArrayList<>());
        return res;
    }
}
