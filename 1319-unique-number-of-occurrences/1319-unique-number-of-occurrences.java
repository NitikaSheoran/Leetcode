class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int x = map.getOrDefault(arr[i],0)+1;
            map.put(arr[i],x);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int x: map.values()){
            if(res.contains(x)){
                return false;
            }
            res.add(x);
        }
        return true;
    }
}