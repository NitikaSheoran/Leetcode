class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int n = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();
        while(i<n && intervals[i][1] < newInterval[0]){
            int[] arr = {intervals[i][0], intervals[i][1]};
            res.add(arr);
            i++;
        }
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int[res.size()][]);
        
    }
}