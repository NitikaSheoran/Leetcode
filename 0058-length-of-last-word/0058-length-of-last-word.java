class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int space=-1;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == ' ') space = i;
        }
        // System.out.println("space: "+ space + "  n: "+n);
        if(space == -1) return n;
        return n-space-1;
    }
}