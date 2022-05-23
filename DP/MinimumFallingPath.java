https://leetcode.com/problems/minimum-falling-path-sum/submissions/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int[][] dp=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix[0].length;i++)
            Arrays.fill(dp[i], -1);
        for(int i=0;i<matrix[0].length;i++)
            min=Math.min(min, find(0,i,matrix,dp));
        return min;
            
    }
    public int find(int r, int c, int[][] matrix, int[][] dp){
        if(c<0 || c>matrix[0].length-1)
            return (int)1e9;
        if(r==matrix.length-1)
            return matrix[r][c];
        if(dp[r][c] != -1)
            return dp[r][c];
        int downLeft=matrix[r][c]+find(r+1, c-1, matrix, dp);
        int down=matrix[r][c]+find(r+1, c, matrix, dp);
        int downRight=matrix[r][c]+find(r+1, c+1, matrix, dp);
        return dp[r][c]=Math.min(downLeft, Math.min(down, downRight));
    }
}
