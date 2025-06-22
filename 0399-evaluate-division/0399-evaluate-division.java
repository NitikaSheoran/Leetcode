class Solution {
    class pair{
        String v;
        double wt;
        pair(String v, double wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public double dfs(String u, String v, Map<String, List<pair>> map, Set<String> seen, Double res){
        if(u.equals(v)) return res;
        seen.add(u);
        for(pair p: map.getOrDefault(u, new ArrayList<>())){
            if(!seen.contains(p.v)){
                double ans = dfs(p.v, v, map, seen, res*p.wt);
                if(ans!=-1) return ans;
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<pair>> map = new HashMap<>();
        int i=0;
        for(List<String> eq: equations){
            String u = eq.get(0);
            String v = eq.get(1);
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(new pair(v, values[i]));
            map.get(v).add(new pair(u, 1.0 / values[i]));
            i++;
        }

        double[] res = new double[queries.size()];
        i=0;
        for(List<String> query: queries){
            String u = query.get(0);
            String v = query.get(1);
        
            if(!map.containsKey(u) || !map.containsKey(v)){
                res[i] = -1;
            }else if(u.equals(v)){
                res[i] = 1;
            }else{
                Set<String> seen = new HashSet<>();
                
                res[i] = dfs(u, v, map, seen, 1.0);
            }
            i++;
        }
        return res;
    }
}