class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";
        for(String word: words){
            char ch;
            int wt = 0;
            for(char c: word.toCharArray()){
                wt += weights[c-'a'];
            }
            wt = wt%26;
            ch = (char)(26-wt-1+'a');
            res += ch;
        }
        return res;
    }
}