// class Solution {
//     public int noAstSub(String s, boolean[] isAst){
//         int n = s.length();
//         int len = 0;
//         long sub = 0;
//         long totalSubstrings = (long) n * (n + 1) / 2;
//         for(int i=0; i<n; i++){
//             if(!isAst[i]){
//                 len++;
//             }else{
//                 sub += (long)(len)*(len+1)/2;
//                 len=0;
//             }
//         }

//         if(len>0){
//             sub += (long)(len)*(len+1)/2;
//         }

//         return (int)(totalSubstrings-sub);
//     }
//     public int minTime(String s, int[] order, int k) {
//         // if(k == 1) return 0;
//         int n = s.length();
//         boolean[] isAst = new boolean[n];

//         for(int t=0; t<n; t++){
//             isAst[order[t]] = true;
//             int subPossible = noAstSub(s, isAst);
//             if(subPossible >= k) return t;
//         }

//         return -1;
//     }
// }
class Solution{
    public long noAstSub(String s, boolean[] isAst){
        int n = s.length();
        int len = 0;
        long sub = 0;
        long totalSubstrings = (long) n * (n + 1) / 2;
        for(int i=0; i<n; i++){
            if(!isAst[i]){
                len++;
            }else{
                sub += (long)(len)*(len+1)/2;
                len=0;
            }
        }

        if(len>0){
            sub += (long)(len)*(len+1)/2;
        }

        return (totalSubstrings-sub);
    }
    public int minTime(String s, int[] order, int k) {
        int n = s.length();
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            boolean[] isAst = new boolean[n];
            Arrays.fill(isAst, false);
            for (int i = 0; i <= mid; i++) {
                isAst[order[i]] = true;
            }

            long count = noAstSub(s, isAst);
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}

