class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(dp[i], -1);
        return path(grid.length-1, grid[0].length-1, grid, dp); 
    }
    public int path(int r, int c, int[][] grid, int[][] dp){
        if(r<0 || c<0)
            return Integer.MAX_VALUE;
        if(dp[r][c] != -1)
            return dp[r][c];
        int right=path(r, c-1, grid, dp);
        int top=path(r-1, c, grid, dp);
        int min=Math.min(right, top);
        if(min==Integer.MAX_VALUE)
            min=0;
        return dp[r][c]=grid[r][c]+min;
    }
}
