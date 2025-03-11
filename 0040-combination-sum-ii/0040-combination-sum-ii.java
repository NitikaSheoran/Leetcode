import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public void comb(int[] candidates, int sum, List<Integer> arr, int target, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(arr));
            return;
        }
        if (sum > target) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue; // Skip duplicate elements
            
            arr.add(candidates[i]);
            comb(candidates, sum + candidates[i], arr, target, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sorting helps handle duplicates
        comb(candidates, 0, new ArrayList<>(), target, 0);
        return res;
    }
}
