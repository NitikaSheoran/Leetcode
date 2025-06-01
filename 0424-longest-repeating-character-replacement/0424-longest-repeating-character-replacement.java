class Solution {
    // longest substring with atmost k unique chars
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0;
        int r=0;
        int maxLen=0;
        int maxRepeat=0;
        Map<Character, Integer> unique = new HashMap<>();
        while(r<n){
            char ch = s.charAt(r);
            unique.put(ch, unique.getOrDefault(ch,0)+1);
            maxRepeat = Math.max(maxRepeat, unique.get(ch));
            if(r-l+1 - maxRepeat > k){
                unique.put(s.charAt(l), unique.get(s.charAt(l))-1);
                if(unique.get(s.charAt(l)) <= 0) unique.remove(s.charAt(l));
                l++;
            }
            
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}