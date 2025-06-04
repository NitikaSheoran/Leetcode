class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j = i; j<n; j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for(int value: map.values()){
                    maxFreq = Math.max(value, maxFreq);
                    minFreq = Math.min(value, minFreq);
                }
                sum += (maxFreq - minFreq);
            }
        }
        return sum;
    }
}