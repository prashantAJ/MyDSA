class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]= new int[word1.length()][word2.length()];
        int n=word1.length(), m=word2.length();
        for(int i=word1.length()-1; i>=0;i--)
            Arrays.fill(dp[i], -1);
        int commonSeq=findCommonSubsequence(n-1, m-1, word1, word2, dp);
        
        if(n>m && commonSeq==m)
            return n-commonSeq;
        else if(commonSeq==n)
                return m-commonSeq;
        return (n-commonSeq)+(m-commonSeq);
    }
    
    public int findCommonSubsequence(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=1+findCommonSubsequence(i-1, j-1, s1, s2, dp);
        return dp[i][j]=Math.max(findCommonSubsequence(i-1, j, s1, s2, dp), findCommonSubsequence(i, j-1, s1, s2, dp));    
    }
}
