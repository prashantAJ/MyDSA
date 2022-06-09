class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()][p.length()];
        for(int i=0;i<s.length();i++)
            Arrays.fill(dp[i], -1);
        return 1 == match(s.length()-1, p.length()-1, s, p, dp);
    }
    public int match(int i, int j, String s1, String s2, int[][] dp){
        if(i==-1){
            while(j>=0){
                if(s2.charAt(j--)!='*')
                    return 0;
            }
            return 1;
        }
        if(j==-1)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        char ch1=s1.charAt(i), ch2=s2.charAt(j);
        int notTake=0,take=0;
        if(ch1==ch2 || ch2=='?')
            return dp[i][j]=match(i-1, j-1, s1, s2, dp);
        else if(ch2=='*'){
            notTake=match(i, j-1, s1, s2, dp);
            take=match(i-1, j, s1, s2, dp);
            return dp[i][j]=take | notTake;
        }
        return dp[i][j]=0;
    }
}
