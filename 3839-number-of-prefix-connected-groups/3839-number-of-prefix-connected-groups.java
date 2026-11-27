class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        if(k==0) return n;

        for(String word: words){
            if(word.length()<k) continue;
            String pref = word.substring(0, k);
            // System.out.println(pref);
            map.put(pref, map.getOrDefault(pref, 0)+1);
        }
        int res = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() >= 2) res++;
        }
        return res;
    }
}