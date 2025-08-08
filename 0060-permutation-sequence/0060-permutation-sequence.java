class Solution {
    int num;
    public void f(int i, int n, int k, String s, List<String> res, Set<Integer> seen){
        if(s.length() == n){
            num++;
            if(k == num){
                res.add(s);
                return;
            }
            return;
        }
        if(num>=k){
            return;
        }
        for(int idx=1; idx<=n; idx++){
            if(seen.contains(idx)) continue;
            s = s+idx;
            seen.add(idx);
            f(idx+1, n, k, s, res, seen);
            seen.remove(idx);
            s = s.substring(0, s.length()-1);
        }
    }
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        num=0;
        f(0, n, k, "", res, seen);

        return res.get(0);
    }
}