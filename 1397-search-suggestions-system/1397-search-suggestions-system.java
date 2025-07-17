class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();

        for(int i=0; i<searchWord.length(); i++){
            String str = searchWord.substring(0, i+1);
            List<String> arr = new ArrayList<>();

            for(int j=0; j<products.length && arr.size() < 3 ; j++){
                String word = products[j];
                if(word.startsWith(str)){
                    arr.add(word);
                }
            }

            res.add(arr);
        }

        return res;
    }
}