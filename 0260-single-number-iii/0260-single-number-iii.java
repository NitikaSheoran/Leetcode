class Solution {
    public int set(int x){
        int cnt = 0;
        int i=0;
        while(((x)&(1<<i)) == 0){
            cnt++;
            i++;
        }
        return cnt;
    }
    public boolean checkBit(int x, int LastSetBit){
        return (x & (1 << LastSetBit)) == 0;
    }
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor ^= nums[i];
        }
        int LastSetBit = set(xor);
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(checkBit(nums[i], LastSetBit)){
                num1.add(nums[i]);
            }else{
                num2.add(nums[i]);
            }
        }
        int x,y;
        int[] res = new int[2];
        xor=0;
        for(int num: num1){
            xor = xor^num;
        }
        x = xor;
        xor=0;
        for(int num: num2){
            xor = xor^num;
        }
        y = xor;
        res[0] = x;
        res[1] = y;
        return res;
    }
}