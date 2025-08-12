class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;

        PriorityQueue<int[]> capitalPq = new PriorityQueue<>((a,b)->{
           return a[0]-b[0];
        });
        PriorityQueue<Integer> profitPq = new PriorityQueue<>((a,b)->b-a);

        for(int i=0; i<n; i++){
            capitalPq.add(new int[]{capital[i], profits[i]});
        }

        for(int i=0; i<k; i++){
            while(!capitalPq.isEmpty() && capitalPq.peek()[0] <= w){
                profitPq.add(capitalPq.poll()[1]);
            }
            if(profitPq.isEmpty()){
                break;
            }
            w += profitPq.poll();
        }

        return w;    
    }
}