class Solution {
    public int sumOfDigits(int num){
        int sum = 0;
        while(num!=0){
            int rightMost = num%10;
            sum += rightMost;
            num = num/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int maxSum = -1;
        for(int i=0; i<nums.length; i++){
            int sum = sumOfDigits(nums[i]);
            ArrayList<Integer> arr = map.getOrDefault(sum, new ArrayList<Integer>());
            if(arr.size() < 2){
                arr.add(nums[i]);
            }else{
                int min = Collections.min(arr);
                if(nums[i]>min){
                    arr.remove(arr.indexOf(min));
                    arr.add(nums[i]);
                }
            }
            map.put(sum, arr);
            if(arr.size()==2){
                maxSum = Math.max(maxSum, arr.get(0)+arr.get(1));
            }
        }
        return maxSum;
        
    }
}