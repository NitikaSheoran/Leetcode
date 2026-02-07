class Solution {
    public int minimumDeletions(String s) {
        int[] a = new int[s.length()];
        int[] b = new int[s.length()];

        b[0]=0;
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i-1);
            if(ch == 'b'){
                b[i]=b[i-1]+1;
            }else{
                b[i]=b[i-1];
            }
        }
        a[s.length()-1]=0;

        for(int i=s.length()-2; i>=0; i--){
            char ch = s.charAt(i+1);
            if(ch == 'a'){
                a[i] = a[i+1]+1;
            }else{
                a[i]=a[i+1];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            min = Math.min(a[i]+b[i], min);
        }
        return min;
    }
}