//GFG
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         int[][] dp=new int[n][W+1];
         for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
         return find(n-1, W, wt, val, dp);
    } 
    static int find(int i, int w, int[] wt, int[] val, int[][] dp){
        if(i==0){
            if(wt[0]<=w)
                return val[0];
            return 0;
        }
        if(dp[i][w] != -1)
            return dp[i][w];
        
        int pick=Integer.MIN_VALUE, notPick=0;
        if(w>=wt[i])
            pick=val[i]+find(i-1, w-wt[i], wt, val, dp);
        notPick=find(i-1, w, wt, val, dp);
        return dp[i][w]=Math.max(pick, notPick);
        
    }
}


