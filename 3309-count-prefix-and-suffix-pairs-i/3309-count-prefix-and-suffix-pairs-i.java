class Solution {
    public boolean isPandS(String sub, String main){
        return main.startsWith(sub) && main.endsWith(sub);
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1;j<words.length; j++){
                if(words[i].length() > words[j].length()) continue;
                if(isPandS(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }
}