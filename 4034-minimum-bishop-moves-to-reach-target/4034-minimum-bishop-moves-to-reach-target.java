class Solution {
    public boolean isDiag(int[] source, int[] target){
        if(Math.abs(source[0]-target[0]) == Math.abs(source[1]-target[1])) return true;
        return false;
    }
    public int minBishopMoves(int[] source, int[] target) {
        boolean isBlack = (source[0]%2 == source[1]%2);
        if(!isBlack && target[0]%2 == target[1]%2) return -1;
        if(isBlack && target[0]%2 != target[1]%2) return -1;
        if(isDiag(source, target)) return 1;
        return 2;
    }
}