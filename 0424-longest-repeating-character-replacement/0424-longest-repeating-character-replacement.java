class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxRepeating = 0;
        int n = s.length();
        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            maxRepeating = Math.max(maxRepeating, map.get(s.charAt(r)));
            if(r-l+1 - maxRepeating>k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}