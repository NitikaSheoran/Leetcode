class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String doubledGoal = goal + goal;
        return doubledGoal.contains(s);
    }
}