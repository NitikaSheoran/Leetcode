class Solution {
    public int numberOfSpecialChars(String word) {
        int lower = 0;
        int upper = 0;
        for(char ch: word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower = lower | (1<<(ch-'a'));
            }else{
                upper = upper | (1<<(ch-'A'));
            }
        }
        int res = lower&upper;
        return Integer.bitCount(res);

    }
}