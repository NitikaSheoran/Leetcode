class Solution {
    static final int MOD = 1000000007;

    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < nums1[i]; j++)
                sb.append('1');

            for (int j = 0; j < nums0[i]; j++)
                sb.append('0');

            list.add(sb.toString());
        }

        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

        long res = 0;

        for (String s : list) {
            for (char ch : s.toCharArray()) {
                res = (res * 2 + (ch - '0')) % MOD;
            }
        }

        return (int) res;
    }
}