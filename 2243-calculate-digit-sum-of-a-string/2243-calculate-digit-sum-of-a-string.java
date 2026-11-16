class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        // int groups = Math.ceil(n/k);
        // if(groups > k){

        // }
      
        while(s.length()>k){
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<s.length(); i+=k){
                int val = 0;
                for(int j=i; j<Math.min(i+k, s.length()); j++){
                    val = val + (s.charAt(j) - '0');
                }
                temp .append(val);
            }
            s = temp.toString();
        }
        return s;
    }
}