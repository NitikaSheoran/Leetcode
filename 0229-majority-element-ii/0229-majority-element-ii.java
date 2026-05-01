class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int maj2 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] == maj1){
                count1++;
            }else if(nums[i] == maj2){
                count2++;
            }else if(count1 == 0){
                maj1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                maj2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        int thresh = n/3;

        for(int i=0; i<n; i++){
            if(nums[i] == maj1){
                count1++;
            }else if(nums[i] == maj2){
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > n/3){
            res.add(maj1);
        }

        if(count2 > n/3){
            res.add(maj2);
        }
        return res;
        

    }
}