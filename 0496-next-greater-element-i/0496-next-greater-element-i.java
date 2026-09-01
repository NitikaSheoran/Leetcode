class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        Stack<Integer> s = new Stack<>();
        res[nums2.length-1] = -1;
        for(int i=nums2.length-1; i>=0; i--){
            int peek = -1;
            if(s.isEmpty() || s.peek()>nums2[i]){
                if(!s.isEmpty()) peek = s.peek();
                s.push(nums2[i]);
            }else{
                while(!s.isEmpty() && s.peek() < nums2[i]){
                    s.pop();
                }
                if(!s.isEmpty()) peek = s.peek();
                s.push(nums2[i]);
            }
            if(s.size() == 1){
                res[i] = -1;
            }else{
                res[i] = peek;
            }
        }
        // for(int i=0; i<nums2.length; i++) System.out.println(res[i]);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){
            int idx = map.get(nums1[i]);

            ans[i] = res[idx];
        }
        return ans;


    }
}