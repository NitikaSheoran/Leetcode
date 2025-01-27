class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int j=0; int i=0;
        int n = fruits.length;
        int maxLen = 0;
        while(j<n){
            map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2){
                map.put(fruits[i], map.get(fruits[i])-1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            j++;
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen-1;
    }
}