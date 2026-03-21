class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        
        // x, y = starting point
        // k = size of square

        for (int i = 0; i < k / 2; i++) {
            for (int col = y; col < y + k; col++) {
                
                int temp = grid[x + i][col];
                grid[x + i][col] = grid[x + k - 1 - i][col];
                grid[x + k - 1 - i][col] = temp;
            }
        }

        return grid;
    }
}