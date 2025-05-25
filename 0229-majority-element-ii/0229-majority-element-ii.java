class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int count1 =0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(count1 == 0 && arr[i] != element2){
                element1 = arr[i];
                count1++;
            }
            else if(count2 ==0 && arr[i] != element1){
                element2 = arr[i];
                count2++;                
            }
            else if(arr[i] == element1){
                count1++;
            }
            else if(arr[i] == element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 =0;
        count2 =0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == element1){
                count1++;
            }
            if(arr[i] == element2){
                count2++;
            }
        }

        if(count1 > arr.length/3){
            list.add(element1);
        }
        if(count2 > arr.length/3 && element2 != element1){
            list.add(element2);
        }

        return list;
    }
}