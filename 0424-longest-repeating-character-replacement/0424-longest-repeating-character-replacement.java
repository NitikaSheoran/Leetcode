class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxRepeat = 0;
        int len = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            maxRepeat = Math.max(maxRepeat, map.get(s.charAt(r)));
            while(r-l+1 - maxRepeat > k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))<=0){
                    map.remove(s.charAt(l));
                }
                l++;
            }

            len = Math.max(r-l+1, len);
            r++;
        }
        return len;
    }
}