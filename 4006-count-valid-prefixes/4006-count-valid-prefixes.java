class Solution {
    public int countValidPrefixes(String s) {
        int zeroC = 0;
        int oneC = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                zeroC++;
            }else{
                oneC++;
            }
            if(Math.abs(zeroC - oneC) == 1 || zeroC-oneC == 0) res++;
        }
        return res;
    }
}