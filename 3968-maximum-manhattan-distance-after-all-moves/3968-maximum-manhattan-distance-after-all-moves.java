class Solution {
    public int maxDistance(String moves) {
        int ver = 0;
        int hor = 0;
        int und = 0;
        for(char ch: moves.toCharArray()){
            if(ch == 'U'){
                ver++;
            }else if(ch == 'D'){
                ver--;
            }else if(ch == 'L'){
                hor++;
            }else if(ch == 'R'){
                hor--;
            }else{
                und++;
            }
        }

        hor = Math.abs(hor);
        ver = Math.abs(ver);

        return hor+ver+und;
    }
}