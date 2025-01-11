class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int maxLen = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                j = Math.max(j, map.get(ch)+1);
            }
            map.put(ch, i);
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}