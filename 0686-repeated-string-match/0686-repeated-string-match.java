class Solution {
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b) || a.contains(b)) return 1;
       
        int count=0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }
        if(sb.toString().contains(b)) return count;
        if(sb.append(a).toString().contains(b)) return ++count;
        return -1;
    }
}