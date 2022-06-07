class Solution {
    public int minDistance(String word1, String word2) {
        //String Matching Pattern
        int[][] dp=new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++)
            Arrays.fill(dp[i], -1);
        return findMinOperations(word1.length()-1, word2.length()-1, word1, word2, dp); 
    }
    public int findMinOperations(int i, int j, String s1, String s2, int[][] dp){
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        if(dp[i][j] != -1)
            return dp[i][j];
        int insert=0, replace=0, remove=0;
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=findMinOperations(i-1, j-1, s1, s2, dp);
        else{
            //Do all possible operations
            insert=1+findMinOperations(i, j-1, s1, s2, dp);
            remove=1+findMinOperations(i-1, j, s1, s2, dp);
            replace=1+findMinOperations(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j]=Math.min(insert, Math.min(remove, replace));
    }
}
