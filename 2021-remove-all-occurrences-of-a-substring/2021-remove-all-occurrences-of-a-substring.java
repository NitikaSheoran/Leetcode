class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder(s);
        while(str.indexOf(part) != -1){
            int start = str.indexOf(part);
            int end = start+part.length();
            str.delete(start,end);
        }
        return str.toString();
    }
}