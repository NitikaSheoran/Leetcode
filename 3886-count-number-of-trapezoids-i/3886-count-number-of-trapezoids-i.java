class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = (long)1e9 + 7;
        Map<Integer, Integer> lineCount = new HashMap<>();
        for (int[] point : points) {
            lineCount.put(point[1], lineCount.getOrDefault(point[1], 0) + 1);
        }

        List<Long> pairCounts = new ArrayList<>();
        for (int count : lineCount.values()) {
            if (count >= 2) {
                long pairs = ((long) count * (count - 1)) / 2;
                pairCounts.add(pairs);
            }
        }

        long totalSum = 0;
        long squareSum = 0;

        for (long val : pairCounts) {
            long modVal = val % MOD;
            totalSum = (totalSum + modVal) % MOD;
            squareSum = (squareSum + (modVal * modVal) % MOD) % MOD;
        }

        // (totalSum^2 - squareSum) / 2 mod MOD
        long totalSquare = (totalSum * totalSum) % MOD;
        long diff = (totalSquare - squareSum + MOD) % MOD;
        long inverseTwo = powMod(2, MOD - 2, MOD);  // Modular inverse of 2
        long ans = (diff * inverseTwo) % MOD;

        return (int) ans;
    }

    private long powMod(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}