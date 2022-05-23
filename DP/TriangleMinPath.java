https://leetcode.com/problems/triangle/submissions/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][];
        for(int i=0;i<triangle.size();i++){
            dp[i]=new int[triangle.get(i).size()];
            Arrays.fill(dp[i], -1);
        }
        return find(0,0,triangle, dp);            
    }
    public int find(int r, int c, List<List<Integer>> tri, int[][] dp){
        if(r==tri.size()-1)
            return tri.get(r).get(c);
        if(dp[r][c] != -1)
            return dp[r][c];
        int down=tri.get(r).get(c)+find(r+1, c, tri, dp);
        int right=tri.get(r).get(c)+find(r+1, c+1, tri, dp);
        return dp[r][c]=Math.min(down, right);
    }
}
