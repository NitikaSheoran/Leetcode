class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int x: map.values()){
            if(x%2 != 0)
            return false;
        }
        return true;
    }
}