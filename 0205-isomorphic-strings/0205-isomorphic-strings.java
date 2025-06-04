class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        int i=0;
        int j=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            char ch2 = t.charAt(j);
            if(ch != ch2){
                if(!map.containsKey(ch)){
                    if(map.containsValue(ch2)){
                        return false;
                    }
                    map.put(ch, ch2);
                }else{
                    char code = map.get(ch);
                    if(code != ch2){
                        return false;
                    }
                }
            }else{
                if(map.containsKey(ch)){
                    if(map.get(ch) != ch2){
                        return false;
                    }
                }else{
                    if(map.containsValue(ch2)){
                        return false;
                    }
                    map.put(ch, ch2);
                }
            }
            i++;
            j++;
        }
        return true;
    }
}