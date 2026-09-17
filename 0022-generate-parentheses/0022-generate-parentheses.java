class Solution {
    public void f(List<String> res, String str, int open, int close, int n){
        if(open == close && open == n){
            res.add(str);
            return;
        }
        if(open > n) return;

        f(res, str+"(", open+1, close, n);
        if(open > close){
            f(res, str+")", open, close+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        f(res, "", 0, 0, n);
        return res;
    }
}