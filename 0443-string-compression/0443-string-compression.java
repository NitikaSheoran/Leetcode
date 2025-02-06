class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        String s="";
        if(chars.length==1){
            return 1;
        }
        int count=1;
        for(int i=1; i<chars.length; i++){
            if(chars[i] == prev){
                count++;
                if(i==chars.length-1){
                    s+=prev;
                    s+=count;
                }
            }else{
                s+=prev;
                if(count!=1){
                    s+=count;
                }
                count=1;
                if(i==chars.length-1){
                    s+=chars[i];
                }
            }
            prev = chars[i];
        }
        for(int i=0; i<s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}