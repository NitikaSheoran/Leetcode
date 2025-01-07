class Solution {
    public int[] computeLps(String str){
        int[] lps = new int[str.length()];
        int currentIdx = 1;
        int len =0;
        while(currentIdx < str.length()){
            if(str.charAt(currentIdx) == str.charAt(len)){
                len++;
                lps[currentIdx] = len;
                currentIdx++;
            }else{
                if(len > 0){
                    len = lps[len-1];
                }else{
                    lps[currentIdx] = 0;
                    currentIdx++;
                }
            }
        }
        return lps;
    }
    public boolean isSub(String str1, String str2, int[] lps){
        int i=0;
        int j=0;
        while(i<str1.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
                if(j==str2.length()) return true;
            }else{
                if(j>0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            int[] lps = computeLps(words[i]);
            for(int j=0; j<words.length; j++){
                if(i==j) continue;
                if(isSub(words[j],words[i],lps)){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

}