class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        int r = 10;
        int turn = 0;
        while(n>0){
            int x = r;
            if(n<x){
                if(turn == 0) return false;
                return true;
            }  
            turn = turn==0?1: 0;
            n = n-x;
            r--;
        }
        return turn==0? false: true;
    }
}