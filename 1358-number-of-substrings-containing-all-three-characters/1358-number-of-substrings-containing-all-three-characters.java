class Solution {
    public int subarr(String s, int k){
        int l = 0;
        int r = 0;
        int len = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while(r<n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            while(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            len += (r-l+1);
            r++;
        }
        return len;
    }
    public int numberOfSubstrings(String s) {
        return subarr(s,3) - subarr(s, 2);
    }
}