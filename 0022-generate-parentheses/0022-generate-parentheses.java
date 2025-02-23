class Solution {
    public void comb(List<String> arr, String str, int open, int closed, int n){
        if(open == n && closed == n){
            arr.add(str);
        }
        if(open<n){
            comb(arr, str+'(', open+1, closed, n);
        }
        if(closed < open){
            comb(arr, str+')', open, closed+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        comb(arr, "", 0, 0, n);
        return arr;
    }
}