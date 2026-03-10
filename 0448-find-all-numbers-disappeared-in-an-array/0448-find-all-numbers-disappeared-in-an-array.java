class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Set<Integer> arr = new HashSet<>();
        for(int num: nums){
            if(num>=1 && num<=n){
                arr.add(num);
            }
        }

        for(int i=1; i<=n; i++){
            if(!arr.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}