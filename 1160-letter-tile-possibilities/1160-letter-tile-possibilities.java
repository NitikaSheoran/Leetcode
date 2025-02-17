class Solution {
    public void generateSeq(String tiles, String current, boolean[]used, Set<String> res){
        res.add(current);
        for(int i=0; i<tiles.length(); i++){
            if(!used[i]){
                used[i]=true;
                generateSeq(tiles, current+tiles.charAt(i), used, res);
                used[i]=false;
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        String current="";
        boolean[] used = new boolean[tiles.length()];
        generateSeq(tiles, current, used, res);
        return res.size()-1;
    }
}