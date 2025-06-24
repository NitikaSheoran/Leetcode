class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flatBoard = new int[n * n];
        int idx = 0;
        boolean leftToRight = true;

        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    flatBoard[idx++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    flatBoard[idx++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n * n - 1) return steps;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next >= n * n) break;

                    int dest = (flatBoard[next] != -1) ? flatBoard[next] - 1 : next;

                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.add(dest);
                    }
                }
            }
            steps++;
        }

        return -1; 
    }
}
