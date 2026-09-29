class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0) return n==1 || n==0;
            else return n==0;
        }
        if(flowerbed[1]==0){
            if(flowerbed[0] == 0){
                flowerbed[0] = 1;
                res++;
            }
        }
        for(int i=1; i<flowerbed.length-1; i++){
            if(flowerbed[i] == 0 && flowerbed[i-1]!=1 && flowerbed[i+1] != 1){
                flowerbed[i] = 1;
                res++;
            }
            if(res>=n) return true;
        }
        if(flowerbed[flowerbed.length-1] == 0){
            if(flowerbed[flowerbed.length-2] == 0) res++;
        }
        return res>=n;
    }
}