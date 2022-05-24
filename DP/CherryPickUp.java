class Solution {
    public int cherryPickup(int[][] grid) {
        int dp[][][]= new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
                    Arrays.fill(dp[i][j], -1);
        }
        return pick(0, 0, grid[0].length-1, grid, dp);
    }
    public int pick(int r, int c1, int c2, int[][] grid, int[][][] dp){
        //Tabulation
        
        //Base Case
        r=grid.length-1;
        for(c1=0; c1<grid[0].length;c1++){
            for(c2=0;c2<grid[0].length;c2++){
                if(c1==c2)
                    dp[r][c1][c2]=grid[r][c1];
                else
                    dp[r][c1][c2]=grid[r][c1]+grid[r][c2];
            }
        }//Base Case End
        //For all indexes from base case +1/-1 till end
        int dir[]=new int[]{-1, 0, 1};
        for(int i=r-1; i>=0; i--){
            for(int j1=0; j1<grid[0].length;j1++){
                for(int j2=0; j2<grid[0].length;j2++){
                    int max=(int)-1e9;
                    for(int ii=0;ii<3;ii++){
                        for(int jj=0;jj<3;jj++){
                            int val=0;
                            if(j1==j2)
                                val=grid[i][j1];
                            else
                                val=grid[i][j1]+grid[i][j2];
                            if(j1+dir[ii]>=0 && j1+dir[ii]<grid[0].length && j2+dir[jj]>=0 && j2+dir[jj]<grid[0].length)
                                val+=dp[i+1][j1+dir[ii]][j2+dir[jj]];
                            else
                                val+=(int)-1e9;
                                //pick(r+1, c1+dir[i], c2+dir[j], grid, dp); 
                            max=Math.max(max,val);
                        }
                    }
                    dp[i][j1][j2]=max;
                    //return dp[r][c1][c2]=max;            
                }    
            }
        }
        return dp[0][0][grid[0].length-1];    
        /*Memoization
        if(c1<0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length)
            return (int)-1e9;
        if(r==grid.length-1){
            if(c1==c2)
                return grid[r][c1];
            else
                return grid[r][c1]+grid[r][c2];
        }
        if(dp[r][c1][c2] != -1)
            return dp[r][c1][c2];
        int max=(int)-1e9;
        int dir[]=new int[]{-1, 0, 1};
        for(int i=0;i<3;i++){
            int val=0;
            for(int j=0;j<3;j++){
                if(c1==c2)
                    val=grid[r][c1]+pick(r+1, c1+dir[i], c2+dir[j], grid, dp);
                else
                    val=grid[r][c1]+grid[r][c2]+pick(r+1, c1+dir[i], c2+dir[j], grid, dp);
                max=Math.max(max,val);
            }
        }
        return dp[r][c1][c2]=max;
        */
    }
}
