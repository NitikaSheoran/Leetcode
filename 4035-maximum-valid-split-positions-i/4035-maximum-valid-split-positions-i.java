class Solution {
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public int maxValidSplits(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=-1; i<n; i++){
            List<Integer> arr = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(i == j) continue;
                arr.add(nums[j]);
            }
            int m = arr.size();
            if(m<2) continue;

            int[] pref = new int[m];
            pref[0] = arr.get(0);

            for(int j=1; j<m; j++){
                pref[j] = gcd(pref[j-1], arr.get(j));
            }

            int[] suff = new int[m];
            suff[m-1] = arr.get(m-1);
            for(int j=m-2; j>=0; j--){
                suff[j] = gcd(suff[j+1], arr.get(j));
            }

            int score = 0;
            for(int j=0; j<m-1; j++){
                if(pref[j] == suff[j+1]) score++;
            }
            ans = Math.max(ans, score);
        }
        return ans;
    }
    
}