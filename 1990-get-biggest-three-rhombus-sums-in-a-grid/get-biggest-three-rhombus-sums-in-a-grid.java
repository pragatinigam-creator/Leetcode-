import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                set.add(grid[i][j]); // single cell rhombus

                for(int size = 1; i + 2*size < m && j-size >= 0 && j+size < n; size++){

                    int sum = 0;

                    int r = i;
                    int c = j;

                    for(int k = 0; k < size; k++) sum += grid[r+k][c-k];
                    for(int k = 0; k < size; k++) sum += grid[r+size+k][c-size+k];
                    for(int k = 0; k < size; k++) sum += grid[r+2*size-k][c+k];
                    for(int k = 0; k < size; k++) sum += grid[r+size-k][c+size-k];

                    set.add(sum);
                }
            }
        }

        int k = Math.min(3, set.size());
        int[] ans = new int[k];

        int i = 0;
        for(int val : set){
            ans[i++] = val;
            if(i == k) break;
        }

        return ans;
    }
}