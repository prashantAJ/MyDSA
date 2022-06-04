// https://practice.geeksforgeeks.org/problems/longest-common-substring1452
int longestCommonSubstr(String s1, String s2, int n, int m){
        int[][] dp=new int[n+1][m+1];
        int ans=Integer.MIN_VALUE;
        //Base Condition (Not needed bcoz dp[][] already has 0 in all indexes)
          //for(int j=0;j<=m;j++) dp[0][j]=0;
          //for(int i=0;i<=m;i++) dp[i][0]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1; j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=0;
                ans=Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
