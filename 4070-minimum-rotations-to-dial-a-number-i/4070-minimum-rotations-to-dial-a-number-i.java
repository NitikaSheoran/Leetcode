class Solution {
    public int minRotations(String s) {
        int res = 0;
        if(s.charAt(0) != '0') {
            int ch = s.charAt(0)-'0';
            res+=Math.min((ch)%10, (10-ch)%10);
        }
        for(int i=0; i<9; i++){
            char ch = s.charAt(i);
            int curr = ch-'0';
            int wanted = s.charAt(i+1) - '0';
            int diff = 0;
            if(curr-wanted < 0){
                diff = Math.min((curr-wanted+10)%10, (wanted-curr)%10);
            }else{
                diff = Math.min((curr-wanted)%10, (wanted-curr+10)%10);
            }
            
            // System.out.println("curr: "+ curr+ "  wanted: "+ wanted + "  diff"+ diff);
            res += diff;
        }
        return res;
    }
}