class Solution {
    public int minRotations(int n, String s) {
        int last = s.charAt(n - 1) - '0';
        int prev = 0;
        int base = 0;
        int gain = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            int cur = c - '0';
            base += dist(prev, cur);
            gain = Math.max(gain, dist(prev, cur) - dist(prev, last));  // cut before cur
            prev = cur;
        }
        return base - gain;
    }
    private int dist(int a, int b) {
        int d = (a - b + 10) % 10;
        return Math.min(d, 10 - d);
    }
}