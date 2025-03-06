class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length * grid.length;
        int sum = (n)*(n+1)/2;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                sum -= grid[i][j];
            }
        }
        int a = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0)+1);
                if(map.get(grid[i][j])==2){
                    a = grid[i][j];
                    break;
                }
            }
        }
        int[] res = new int[2];
        res[0] = a;
        res[1] = sum+a;
        return res;
    }
}