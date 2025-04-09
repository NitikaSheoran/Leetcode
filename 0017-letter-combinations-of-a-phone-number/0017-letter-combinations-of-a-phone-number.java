class Solution {
    static String keys[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static void comb(String a,int idx,String newstr,ArrayList<String> result){
        if(idx == a.length()){
            result.add(newstr);
            return;
        }
        for(int i = 0;i<keys[a.charAt(idx) - '0'].length();i++){
            comb(a,idx+1,newstr+keys[a.charAt(idx) - '0'].charAt(i),result);
        }
    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result= new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        comb(digits,0,"",result);
        return result;
    }
}