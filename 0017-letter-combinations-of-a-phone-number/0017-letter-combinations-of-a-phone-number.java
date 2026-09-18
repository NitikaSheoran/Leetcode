class Solution {
    static String keys[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void f(List<String> res, String str, int idx, String digits){
        if(idx == digits.length()){
            res.add(str);
            return;
        }
        
        for(int i = 0; i<keys[digits.charAt(idx)-'0'].length(); i++){
            f(res, str+keys[digits.charAt(idx)-'0'].charAt(i), idx+1, digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        f(res, "", 0, digits);
        return res;
    }
}