public int findPath(int r, int c, int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        if(grid[0][0]==0)
            dp[0][0]=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!(i==0 && j==0) && grid[i][j]==0){
                    int x=0,y=0;
                    if(j-1 >= 0 && grid[i][j-1] == 0)
                    x=dp[i][j-1];
                    if(i-1>=0 && grid[i-1][j] == 0)
                        y=dp[i-1][j];
                    dp[i][j]=x+y;
                }
                    
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
