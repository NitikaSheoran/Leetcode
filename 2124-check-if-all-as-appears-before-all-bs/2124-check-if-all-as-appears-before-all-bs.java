class Solution {
    public boolean checkString(String s) {
        boolean bApp = false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'b'){
                bApp = true;
            }
            if(s.charAt(i) == 'a' && bApp){
                return false;
            }
        }
        return true;
    }
}