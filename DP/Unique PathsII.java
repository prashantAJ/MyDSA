public int findPath(int r, int c, int[][] grid, int[][] dp){
        if(r==0 && c==0 && grid[r][c]==0)
            return 1;
        if(dp[r][c] != -1)
            return dp[r][c];
        int top=0,right=0;
        if(c-1>=0 && grid[r][c-1]==0)
            right=findPath(r, c-1, grid, dp);
        if(r-1>=0 && grid[r-1][c]==0)
            top=findPath(r-1, c, grid, dp);
        return dp[r][c]=top+right;
    }
}

//dp=-1
//findPath(n-1,m-1,grid,dp);
