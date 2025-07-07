// class Solution {

//     public int maxEvents(int[][] events) {
//         int n = events.length;
//         Arrays.sort(events, (a,b) -> a[1] - b[1]);

//         int max = 0;
//         // for(int i=0; i<n; i++){
//         //     max = Math.max(max, events[i][1]);
//         // }
//         max = events[n-1][1];

//         boolean[] attended = new boolean[max+1];
//         int count = 0;
//         for(int i=0; i<n; i++){
//             int start = events[i][0];
//             int end = events[i][1];
//             while(start <= end && attended[start]){
//                 start++;
//             }
//             if(end >= start && !attended[start]){
//                 attended[start] = true;
//                 count++;
//             }
//         }
//         return count;
//     }
// }


class Solution {
    int[] parent;

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        parent[x] = y;
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); 

        int maxDay = 0;
        for (int[] e : events) maxDay = Math.max(maxDay, e[1]);
        parent = new int[maxDay + 2]; 
        for (int i = 0; i <= maxDay + 1; i++) parent[i] = i;

        int count = 0;

        for (int[] event : events) {
            int availableDay = find(event[0]);
            if (availableDay <= event[1]) {
                count++;
                union(availableDay, availableDay + 1);
            }
        }

        return count;
    }
}
