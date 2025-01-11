class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        if(k == s.length()) return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int count = 0;
        for (char key : map.keySet()) {
            if(map.get(key)%2 != 0){
                count++;
            }
        }
        return count<=k ;
    }
}