class Solution {
    public int tupleSameProduct(int[] nums) {
        if(nums.length<4) return 0;
        Arrays.sort(nums);
        int count = 0;
        // int i=0;
        // int j=nums.length-1;
        // while(i<j){
        //     int currMul = nums[i]*nums[j];
        //     int l = i+1;
        //     int r = j-1;
        //     while(l<r){
        //         int m = nums[l]*nums[r];
        //         if(m==currMul){
        //             count++;
        //             l++;
        //             r--;
        //         }else if(m>currMul){
        //             r--;
        //         }else{
        //             l++;
        //         }
        //     }
        //     i++;
        //     j--;
        // }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j], 0)+1);
            }
        }
        for(int x: map.keySet()){
            int freq = map.get(x);
            count += 8*((freq)*(freq-1)/2);
        }
        return count;
    }
}