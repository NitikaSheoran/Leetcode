class Solution {
    public void sub(String s, int idx, List<List<String>> res, List<String> path){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                path.add(s.substring(idx,i+1));
                sub(s, i+1, res, path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int st, int end){
        while(st<end){
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        sub(s, 0, res, path);
        return res;
    }
}