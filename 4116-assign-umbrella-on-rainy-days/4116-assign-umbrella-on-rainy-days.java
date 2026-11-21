class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] res = new String[n];
        int Alice = 0;
        int Bob = 0;

        for(int i=0; i<n-1; i++){
            if(rain[i] == 1 && rain[i+1] == 1){
                if(Alice<=Bob){
                    Alice++;
                    res[i] = "Alice";
                }else{
                    Bob++;
                    res[i] = "Bob";
                }
            }else if(rain[i] == 1){
                res[i] = "Bob";
                Bob++;
            }else{
                res[i] = "None";
            }
        }
        if(rain[n-1] == 1){
            res[n-1] = "Bob";
        }else{
            res[n-1] = "None";
        }
        return res;
    }
}