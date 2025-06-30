class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[1], b[1]));
        int count = 0;
        int end = points[0][1];
        int n = points.length;
        int i=0;
        while(i<n){
            while(i<n && points[i][0] <= end){
                i++;
            }
            count++;
            if(i<n) end = points[i][1];
        }
        return count;
    }
}