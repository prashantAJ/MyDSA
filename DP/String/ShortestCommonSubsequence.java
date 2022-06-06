class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        //if(i1<0 || i2<0)
          //  return 0; No need to write base condition (all indexes are by default 0)
      //LCS Tabulation to use dp array for creating Shortest Common Subsequence..  
      for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) //string charactor comparison
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);        
            }
        }
        //return dp[str1.length()][str2.length()];
        String result="";
        int i=str1.length(),j=str2.length();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                result=String.valueOf(str1.charAt(i-1))+result;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    result=String.valueOf(str1.charAt(i-1))+result;
                    i--;
                }
                else{
                    result=String.valueOf(str2.charAt(j-1))+result;
                    j--;
                }
            }
        }
        while(i>0){
            result=String.valueOf(str1.charAt(i-1))+result;
            i--;
        }
        while(j>0){
            result=String.valueOf(str2.charAt(j-1))+result;
            j--;   
        }
        return result;
    }
}
