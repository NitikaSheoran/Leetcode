class Solution {
    class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findPar(int x){
            if(x == parent[x]){
                return x;
            }

            return parent[x] = findPar(parent[x]);
        }

        public boolean union(int x, int y){
            int px = findPar(x);
            int py = findPar(y);
            
            System.out.println("x =  " + x + "  px = " + px + "   y = " + y + "  py = " + py);

            if(px == py) return false;

            if(size[px] < size[py]){
                parent[px] = py;
                size[py] += size[px];
            }else{
                parent[py] = px;
                size[px] += size[py];
            }

            return true;
        }
    }
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);

        for(String str: equations){
            int x = str.charAt(0)-'a';
            int y = str.charAt(3)-'a';
            boolean isEq = str.charAt(1) == '=';

            if(isEq) dsu.union(x, y);
        }
        for(String str: equations){
            int x = str.charAt(0)-'a';
            int y = str.charAt(3)-'a';
            boolean isEq = str.charAt(1) == '=';

            if(!isEq && dsu.findPar(x) == dsu.findPar(y)){
                return false;
            }
        }
        

        return true;
    }
}