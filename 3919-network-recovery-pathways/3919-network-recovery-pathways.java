// class Solution {
//     int max = -1;
//     public void dfs(int node, long sum, long k, ArrayList<ArrayList<int[]>> adjList, boolean[] online, long min){
//         if(sum > k || min<=max) return;
//         if(node == adjList.size()-1){
//             if(sum<=k){
//                 max = (int)Math.max(max, min);
//             }
//             return;
//         }

//         for(int[] adj: adjList.get(node)){
//             int v = adj[0];
//             int w = adj[1];
//             if(v!=0 && sum+w <= k && online[v] == true){
//                 dfs(v, sum+w, k, adjList, online, Math.min(min, w));
//             }
//         }
//     }
//     public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
//         ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
//         int n = online.length;

//         for(int i=0; i<n; i++){
//             adjList.add(new ArrayList<>());
//         }

//         for(int[] edge: edges){
//             int u = edge[0];
//             int v = edge[1];
//             int w = edge[2];
//             adjList.get(u).add(new int[]{v, w});
//         }
        
        
        
//         dfs(0, 0, k, adjList, online, Long.MAX_VALUE);
//         return max;
        
//     }
// }

class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private boolean check(List<List<Pair>> adj,int x,long k,int n,boolean[] online){
        long[] arr=new long[n];
        Arrays.fill(arr,Long.MAX_VALUE);
        arr[0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long cost=curr[0];
            int u=(int)curr[1];
            if(cost>arr[u]) continue;
            if(u==n-1) break;
            for(Pair p:adj.get(u)){
                int v=p.x,y=p.y;
                if(y>=x&&online[v]){
                    if(arr[u]+y<arr[v]){
                        arr[v]=arr[u]+y;
                        pq.offer(new long[]{arr[v],v});
                    }
                }
            }
        }
        return arr[n-1]<=k;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length,m=edges.length;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge:edges) adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        int low=0,high=(int)1e9,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(adj,mid,k,n,online)){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }
        return ans;
    }
}