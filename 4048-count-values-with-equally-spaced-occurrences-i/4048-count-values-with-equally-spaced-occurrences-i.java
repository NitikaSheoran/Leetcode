class Solution {
    public int countSpecialIntegers(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int res = 0;

        for (List<Integer> indices : map.values()) {
            if (indices.size() == 3) {
                int a = indices.get(0);
                int b = indices.get(1);
                int c = indices.get(2);

                if (b - a == c - b) {
                    res++;
                }
            }
        }

        return res;
    }
}