class Solution {
    public void f(int open, int close, int n, String str, List<String> res){
        if(open == close && open == n){
            res.add(str);
            return;
        }
        if(open > n) return;

        
        f(open+1,close,n,str+"(",res);
        if(open>close){
            f(open, close+1, n, str+")", res);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        f(0, 0, n, "", res);
        return res;
    }
}