int[][] dp=new int[str1.length()+1][str2.length()+1];
        //if(i1<0 || i2<0)
          //  return 0; No need to write base condition (all indexes are by default 0)
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) //string charactor comparison
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);        
            }
        }
        return dp[str1.length()][str2.length()];
