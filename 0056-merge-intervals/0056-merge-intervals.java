class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        if(intervals.length == 0 || intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i=1; i<intervals.length; i++){
            while(i<intervals.length && intervals[i][0]<=end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(start);
            arr.add(end);
            res.add(arr);
            if(i<intervals.length) start = intervals[i][0];
            if(i<intervals.length) end = intervals[i][1];
            i--;
        }

        int[][] ans = new int[res.size()][2];
        int i=0;
        for(List<Integer> arr: res){
            int st = arr.get(0);
            int e = arr.get(1);
            ans[i][0] = st;
            ans[i][1] = e;
            i++;
        }

        return ans;
    }
}