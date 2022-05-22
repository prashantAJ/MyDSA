class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        return dfs(0, 0, m, n, dp);
    }
    public int dfs(int r, int c, int m, int n, int[][] dp){
        if(r==m-1 && c==n-1)
            return 1;
        if(dp[r][c] != -1)
            return dp[r][c];
        int left=0;
        if(c+1 < n)
            left=dfs(r, c+1, m, n, dp);
        int right=0;
        if(r+1 < m)    
            right=dfs(r+1, c, m, n, dp);
        return dp[r][c]=left+right;
    }
}
