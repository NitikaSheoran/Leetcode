class Solution {
    // public boolean isSub(String main, String sub){
    //     if(main.length() < sub.length()){
    //         return false;
    //     }
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for(int i=0; i<main.length(); i++){
    //         char ch = main.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0)+1);
    //     }
    //     for(int i=0; i<sub.length(); i++){
    //         char ch = sub.charAt(i);
    //         if(map.getOrDefault(ch,0) > 0){
    //             map.put(ch, map.getOrDefault(ch,0)-1);
    //         }else{
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public int[] freq(String str){
        int[] arr = new int[26];
        for(char ch: str.toCharArray()){
            arr[ch-'a']++;
        }
        return arr;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        // for(String a: words1){
        //     int count = 0;
        //     for(String b: words2){
        //         if(isSub(a,b)){
        //             count++;
        //         }else{
        //             break;
        //         }
        //     }
        //     if(count==words2.length){
        //         res.add(a);
        //     }
        // }


        int[] bMax = freq("");
        for(String str: words2){
            int[] bCount = freq(str);
            for(int i=0; i<26; i++){
                bMax[i] = Math.max(bCount[i], bMax[i]);
            }
        }

        search: for(String str: words1){
            int[] aCount = freq(str);
            for(int i=0; i<26; i++){
                if(aCount[i] < bMax[i]) continue search;
            }
            res.add(str);
        }
        return res;
    }
}