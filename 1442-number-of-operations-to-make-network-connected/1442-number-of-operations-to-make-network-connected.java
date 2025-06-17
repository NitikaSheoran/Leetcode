class Solution {
    class dsu{
        int[] par;
        int[] size;
        dsu(int s){
            par = new int[s];
            size = new int[s];
            for(int i=0; i<s; i++){
                par[i] = i;
                size[i] = 1;
            }
        }

        public int parent(int u){
            if(u == par[u]) return u;
            return par[u] = parent(par[u]);
        }

        public void union(int u, int v){
            int pU = parent(u);
            int pV = parent(v);

            if(pU == pV) return;

            if(size[pU] < size[pV]){
                par[pU] = par[pV];
                size[pV] += size[pV];
            }else{
                par[pV] = par[pU];
                size[pU] += size[pV];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        dsu D = new dsu(n);

        int ans = 0;
        for(int i=0; i<connections.length; i++){
            D.union(connections[i][0], connections[i][1]);
        }
        for(int i=0; i<n; i++){
            if(D.par[i] == i){
                ans++;
            }
        }
        return ans-1;

    }
}