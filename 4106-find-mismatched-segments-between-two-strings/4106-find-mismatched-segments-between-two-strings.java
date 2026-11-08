class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res = new ArrayList<>();
        int n = s1.length();
        int i=0;
        int l=0;
        while(i<n){
            String sub1 = "";
            String sub2 = "";
            while(l<n && s1.charAt(l) != s2.charAt(l)){
                sub1 += s1.charAt(l);
                sub2 += s2.charAt(l);
                l++;
            }
        
            if(sub1 != ""){
                List<String> str = new ArrayList<>();
                str.add(sub1);
                str.add(sub2);
                res.add(str);
            }
            l++;
            i=l;
        }
        return res;
    }
}