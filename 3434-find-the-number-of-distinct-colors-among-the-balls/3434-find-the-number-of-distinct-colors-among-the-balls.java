class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[queries.length];
        int uniqueColors=0;
        for(int i=0; i<queries.length; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(map.containsKey(ball)){
                int prevColor = map.get(ball);
                freq.put(prevColor, freq.get(prevColor)-1);
                if(freq.get(prevColor)<=0){
                    freq.remove(prevColor);
                }
            }
            map.put(ball, color);
            freq.put(color, freq.getOrDefault(color,0)+1);
            uniqueColors = freq.size();
            res[i] = uniqueColors;
        }
        return res;
    }
}