class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<candies.length; i++){
            if(max < candies[i]){
                max = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}