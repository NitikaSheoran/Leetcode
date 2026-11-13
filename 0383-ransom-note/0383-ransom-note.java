class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rans = new int[27];
        int[] mag = new int[27];
        for(int i=0; i<ransomNote.length(); i++){
            int ch = ransomNote.charAt(i)-'a';
            rans[ch]++;
        }
        for(int i=0; i<magazine.length(); i++){
            int ch = magazine.charAt(i)-'a';
            mag[ch]++;
        }
        for(int i=0; i<27; i++){
            if(mag[i] < rans[i]) return false;
        }
        return true;
    }
}