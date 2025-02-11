class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }
        for(int num: nums2){
            set2.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res0 = new ArrayList<>();
        for(int x: set1){
            if(!set2.contains(x)){
                res0.add(x);
            }
        }
        List<Integer> res1 = new ArrayList<>();
        for(int x: set2){
            if(!set1.contains(x)){
                res1.add(x);
            }
        }
        res.add(res0);
        res.add(res1);
        return res;
    }
}