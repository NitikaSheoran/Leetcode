class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        int n = bills.length;
        int i=0;
        while(i<n){
            int note = bills[i];
            if(note == 5){
                five++;
            }
            if(note == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }
            if(note == 20){
                if(!((ten>=1 && five>=1) || (five>=3))) return false;
                if(!(ten>=1 && five>=1)){
                    five -= 3;
                }else{
                    ten--;
                    five--;
                }
                twenty++;
            }
            i++;
        }
        return true;
    }
}