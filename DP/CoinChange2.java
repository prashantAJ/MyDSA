class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            Arrays.fill(dp[i],-1);
        return ways(coins.length-1, amount, coins, dp);
    }
    public int ways(int i, int amount, int[] coins, int[][] dp){
        if(amount<0)
            return 0;
        if(amount == 0)
            return 1;
        if(i==0){
            if(amount%coins[i] == 0)
                return 1;
            else 
                return 0;
        }
        if(dp[i][amount] != -1)
            return dp[i][amount];
        int take=ways(i, amount-coins[i], coins, dp);
        int notTake=ways(i-1, amount, coins, dp);
        return dp[i][amount]=take+notTake;
    }
}
