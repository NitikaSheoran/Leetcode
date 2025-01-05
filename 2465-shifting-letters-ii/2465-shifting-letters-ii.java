class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] delta = new int[s.length()+1];
        for(int[] shift: shifts){
            int start = shift[0];
            int end = shift[1];
            int d = shift[2]==0?-1:1;
            delta[start] += d;
            delta[end+1] -= d;
            
        }
         int shift = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            shift += delta[i]; 
            chars[i] = (char) ((chars[i] - 'a' + shift % 26 + 26) % 26 + 'a');
        }
        
        return new String(chars);
        
    }
}