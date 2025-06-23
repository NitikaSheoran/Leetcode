class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int l = 0, r = m - 1, ans = m;
            while (l <= r) {
                int mid = (l + r) / 2;
                if ((long)spell * potions[mid] >= success) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = m - ans;
        }
        return res;
    }
}
