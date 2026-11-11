class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res = 0;
        if(cost1 + cost2 > costBoth){
            res += (long)Math.min(need1, need2)*costBoth;
        }else{
            return (long)need1*cost1 + (long)need2*cost2;
        }

        long remaining = Math.abs(need1 - need2);

        long individualCost = (need1 > need2) ? cost1 : cost2;

        res += Math.min(
            remaining * costBoth,
            remaining * individualCost
        );

        return res;
    }
}