class Solution {
    class Node{
        String to;
        double wt;

        Node(String to, double wt){
            this.wt = wt;
            this.to = to;
        }
    }
    
    public double findQuery(String u, String v, Map<String, List<Node>> map, Set<String> seen, Double res){
        if(u.equals(v)) return res;
        seen.add(u);
        for(Node p: map.getOrDefault(u, new ArrayList<>())){
            if(!seen.contains(p.to)){
                double ans = findQuery(p.to, v, map, seen, res*p.wt);
                if(ans!=-1) return ans;
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Node>> adjL = new HashMap<>();
        int i =0 ;
        for(List<String> pair: equations){
            String u = pair.get(0);
            String v = pair.get(1);
            double wt = values[i]; 
            if(!adjL.containsKey(u)){
                adjL.put(u, new ArrayList<Node>());
            }
            if(!adjL.containsKey(v)){
                adjL.put(v, new ArrayList<Node>());
            }
            adjL.get(u).add(new Node(v, wt));
            adjL.get(v).add(new Node(u, 1/wt));
            i++;
        }
        int n = queries.size();
        double[] res = new double[n];
        i=0;
        for(List<String> query: queries){
            String u = query.get(0);
            String v = query.get(1);
            if(!adjL.containsKey(u) || !adjL.containsKey(v)){
                res[i] = -1;
            }else if(u.equals(v)){
                res[i] = 1;
            }else{
                Set<String> set = new HashSet<>();
                double res1 = 1;
                res[i] = findQuery(u, v, adjL, set, res1);
            }
            i++;
        }
        return res;

    }
}