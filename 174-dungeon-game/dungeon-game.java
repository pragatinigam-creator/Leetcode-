class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);

        return solve(0, 0, m, n, dungeon, memo);
    }

    private int solve(int i, int j, int m, int n, int[][] grid, int[][] memo) {
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] < 0 ? Math.abs(grid[i][j]) + 1 : 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int down = solve(i + 1, j, m, n, grid, memo);
        int right = solve(i, j + 1, m, n, grid, memo);

        int needed = Math.min(down, right) - grid[i][j];
        memo[i][j] = (needed <= 0) ? 1 : needed;
        return memo[i][j];
    }
}