class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countpaths(m,n,1,1,dp);
    }

    public static int countpaths(int m, int n,int r, int c, int[][] dp ){
        if (r==m && c==n){
            return 1;
        }
        if(r>m || c>n) return 0;
        if(dp[r][c]!=-1) return dp[r][c];

        int count=0;
        count = count +  countpaths(m, n, r, c+1,dp);
        count = count + countpaths(m, n, r+1, c,dp);

        dp[r][c] = count;

        return count ;
    }
}