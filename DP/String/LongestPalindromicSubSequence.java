//Same as LongestCommonSubsequence just pass original and reversed string
class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverse="";
        int[][] dp=new int[s.length()][s.length()];
        for(int i=s.length()-1; i>=0;i--){
            reverse+=String.valueOf(s.charAt(i));
            Arrays.fill(dp[i], -1);
        }
        return findCommonSubsequence(s.length()-1, s.length()-1, s, reverse, dp);
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
