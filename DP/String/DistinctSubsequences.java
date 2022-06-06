class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
            Arrays.fill(dp[i], -1);
        return findWays(s.length()-1, t.length()-1, s, t, dp);
    }
    public int findWays(int i, int j, String s1, String s2, int[][] dp){
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=findWays(i-1, j-1, s1, s2, dp) + findWays(i-1, j, s1, s2, dp);
        }
        return dp[i][j]=findWays(i-1, j, s1, s2, dp);
    }
}
