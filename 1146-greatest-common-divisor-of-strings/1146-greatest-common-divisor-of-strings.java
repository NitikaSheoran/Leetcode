class Solution {
    public boolean isDiv(String str1, String str2, String sub){
        int n = str1.length();
        int m = str2.length();
        int i = 0;
        String temp = "";
        while(i<str1.length()){
            temp = temp+sub;
            i += sub.length();
        }
        if(!temp.equals(str1)){
            return false;
        }
        i = 0;
        temp = "";
        while(i<m){
            temp = temp + sub;
            i+=sub.length();
        }
        if(!(temp.equals(str2))){
            return false;
        }
        return true;
        
    }
    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        int n = str1.length();
        int m = str2.length();
        int min = Math.min(n,m);
        for(int i=0; i<min; i++){
            if(isDiv(str1, str2, str2.substring(0,i+1))){
                res = str2.substring(0,i+1);
            }
        }
        return res;
    }
}