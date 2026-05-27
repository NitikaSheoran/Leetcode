class Solution {
    public int numberOfSpecialChars(String word) {
        int[] a = new int[26];
        int[] A = new int[26];
        Arrays.fill(a, -1);
        Arrays.fill(A, -1);
        int i = 0;
        for(char c: word.toCharArray()){
            if(Character.isUpperCase(c) && A[c-'A']==-1){

                A[c-'A'] = i;
            }
            if(Character.isLowerCase(c)){
                a[c-'a'] = i;
            }
            i++;
        }

        int res = 0;
        for(i=0; i<26; i++){
            if(a[i] != -1 && A[i] != -1 && a[i]<A[i]){
                res++;
            }
        }

        return res;


    }
}