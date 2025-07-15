class Solution {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public boolean isValid(String word) {
        if(word.length() < 3) return false;

        int ch = 0;
        int vowel = 0;
        int cons = 0;
        for(char c: word.toCharArray()){
            if(Character.isDigit(c)){
                ch++;
                continue;
            }

            if(!Character.isLetterOrDigit(c)){
                return false;
            }else{
                if(isVowel(Character.toLowerCase(c))){
                    vowel++;
                    ch++;
                }else{
                    cons++;
                    ch++;
                }
            }
        }

        return ch>=3 && vowel>=1 && cons>=1;
    }
}