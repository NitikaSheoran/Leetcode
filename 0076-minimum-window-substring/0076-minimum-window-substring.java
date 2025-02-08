class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int count = 0;
        int stIdx = -1;
        int minl = Integer.MAX_VALUE;
        for(int i =0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<s.length()){
            char ch = s.charAt(r);
             if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    count++;
                }
            }
            while(count == t.length()){
                if(r-l+1<minl){
                    minl = r-l+1;
                    stIdx = l;
                }
                char ch2 = s.charAt(l);
                if (map.containsKey(ch2)){
                    map.put(ch2, map.get(ch2) + 1);
                    if (map.get(ch2) > 0){
                        count--;
                    }
                }
                l++;
            }
            r++;
        }
        return stIdx==-1 ? "" : s.substring(stIdx,stIdx + minl);
        
    }
}