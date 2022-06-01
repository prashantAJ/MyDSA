class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++)
            Arrays.fill(dp[i], -1);
        return findCommon(text1.length()-1, text2.length()-1, text1, text2, dp);
    }
    public int findCommon(int i1, int i2, String text1, String text2, int[][] dp){
        if(i1<0 || i2<0)
            return 0;
        if(dp[i1][i2] != -1)
            return dp[i1][i2];
        if(text1.charAt(i1)==text2.charAt(i2))
            return dp[i1][i2] = 1+findCommon(i1-1, i2-1, text1, text2, dp);
        return dp[i1][i2] = Math.max(findCommon(i1-1, i2, text1, text2, dp), findCommon(i1, i2-1, text1, text2, dp));
    }
}
