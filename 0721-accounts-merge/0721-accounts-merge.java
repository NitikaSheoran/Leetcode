class Solution {
    class DisjointSet{
        int[] par;
        int[] size;
        DisjointSet(int size){
            this.par = new int[size];
            this.size = new int[size];
            for(int i=0; i<size; i++){
                par[i] = i;
                this.size[i] = 1;
            }
        }

        public int parent(int u){
            if(u == par[u]){
                return u;
            }
            return par[u] = parent(par[u]);
        }

        public void union(int u, int v){
            int pU = parent(u);
            int pV = parent(v);
            if(pU == pV) return;

            if(size[pU] < size[pV]){
                par[pU] = pV;
                size[pV] += size[pU];
            }else{
                par[pV] = pU;
                size[pU] += size[pV];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet dsu = new DisjointSet(n);

        Map<String, Integer> mGrp = new HashMap<>();
        for(int i=0; i<n; i++){
            int size = accounts.get(i).size();

            for(int j=1; j<size; j++){
                String email = accounts.get(i).get(j);
                String acc = accounts.get(i).get(0);

                if(!mGrp.containsKey(email)){
                    mGrp.put(email,i);
                }else{
                    dsu.union(i, mGrp.get(email));
                }
            }
        }

        Map<Integer, List<String>> components = new HashMap<>();
        for(String email: mGrp.keySet()){
            int grp = mGrp.get(email);
            int grpRep = dsu.parent(grp);

            if(!components.containsKey(grpRep)){
                components.put(grpRep, new ArrayList<String>());
            }

            components.get(grpRep).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for(int grp: components.keySet()){
            List<String> component = components.get(grp);
            Collections.sort(component);
            component.add(0, accounts.get(grp).get(0));
            res.add(component);
        }
        return res;


    }
}