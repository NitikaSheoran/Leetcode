class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        int n=s.length();
        int maxLen = 0;
        while(r<n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l=Math.max(l, map.get(ch)+1);
            }
            map.put(ch, r);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}