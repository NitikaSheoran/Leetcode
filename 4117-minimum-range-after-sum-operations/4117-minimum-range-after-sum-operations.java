class Solution {
    public int minRange(int a, int b, int c) {
        int max = Math.max(a, Math.max(b,c));
        int min = Math.min(a, Math.min(b,c));
        int range = max-min;

        int sum = a+b+c;
        int x = Math.min(sum-max-min, sum-min-max);
        range = Math.min(range, x);
        return range;
    }
}