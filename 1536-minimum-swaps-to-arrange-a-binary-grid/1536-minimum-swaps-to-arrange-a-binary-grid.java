class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] rightMostOne = new int[n];
        Arrays.fill(rightMostOne, -1);
        int swaps = 0;
        for(int i = 0 ; i < n ; ++i){
            for(int j = n-1 ; j >= 0 ; --j){
                if(grid[i][j] == 1){
                    rightMostOne[i] = j;
                    break;
                }
            }
        }

        for(int i = 0 ; i < n ; ++i){
            int j = i;
            while(j< n && rightMostOne[j] > i)
                ++j;

            if(j == n)
                return -1;

            while( j > i){
                int temp = rightMostOne[j];
                rightMostOne[j] = rightMostOne[j-1];
                rightMostOne[j-1] = temp;
                --j;
                ++swaps;
            }
        }
        return swaps;
    }
}