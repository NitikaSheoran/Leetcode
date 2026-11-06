class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0;

        for (int[] query : q) {

            int start = query[0] - x;
            int end = query[0];

            while (r < logs.length && logs[r][1] <= end) {
                map.put(logs[r][0],
                    map.getOrDefault(logs[r][0], 0) + 1);
                r++;
            }

            // Remove logs with timestamp < start
            while (l < r && logs[l][1] < start) {

                int id = logs[l][0];

                map.put(id, map.get(id) - 1);

                if (map.get(id) == 0) {
                    map.remove(id);
                }

                l++;
            }

            ans[query[1]] = n - map.size();
        }

        return ans;
    }
}