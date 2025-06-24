class Solution {
    public boolean find(int[] gas, int[] cost, int idx){
        int currGas = gas[idx];
        int n = gas.length;
        for(int i=idx; i<idx+n; i++){
            int l = i%(n);
            if(currGas < cost[l]) return false;
            currGas = currGas + gas[(l+1)%n] - cost[l];
        }
        return true;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i=0;
        int n = gas.length;
        if(n == 1 && gas[0] >= cost[0]) return 0;
        ArrayList<Integer> possibleIdx = new ArrayList<>();
        for(i=0; i<n; i++){
            if(gas[i] > cost[i]) possibleIdx.add(i);
        }
        for(int idx: possibleIdx){
            if(find(gas, cost, idx)) return idx;
        }
        return -1;
    }
}