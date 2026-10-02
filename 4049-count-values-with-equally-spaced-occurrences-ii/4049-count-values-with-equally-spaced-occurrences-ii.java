class Solution {
    public boolean isValid(ArrayList<Integer> arr){
        int diff = arr.get(1)-arr.get(0);
        for(int i=0; i<arr.size()-1; i++){
            int curr = arr.get(i);
            int next = arr.get(i+1);
            int newdiff = next-curr;
            if(newdiff != diff) return false;
        }
        return true;
    }
    public int countSpecialIntegers(int[] nums) {
        int res = 0;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (ArrayList<Integer> arr : map.values()) {
            if (arr.size() >= 3) {
                if(isValid(arr)) res++;
            }
        }

        return res;
    }
}