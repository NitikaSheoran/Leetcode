class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> freqMap = new HashMap<>();
        char[] chars = new char[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                chars[col] = (char) (grid[row][col] + '0');
            }
            String s = new String(chars);
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                chars[row] = (char) (grid[row][col] + '0');
            }

            String s = new String(chars);
            if (freqMap.containsKey(s))
                count += freqMap.get(s);
        }

        return count;
    }
}