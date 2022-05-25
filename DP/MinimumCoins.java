//Coin Change
public int countCoins(int i, int amount, int[] coins, int[][] dp){
       if(i==0){
            if(amount%coins[0] == 0)
                return amount/coins[0];
            else
                return (int)1e9;
        }
        if(dp[i][amount] != -1)
           return dp[i][amount];
        int pick=(int)1e9;
        if(amount-coins[i]>=0) 
            pick=1+countCoins(i, amount-coins[i], coins, dp);
        int notPick=countCoins(i-1, amount, coins, dp);
        return dp[i][amount]=Math.min(pick, notPick);
 }
