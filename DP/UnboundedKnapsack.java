class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp=new int[N][W+1];
        for(int i=0; i<N; i++)
            Arrays.fill(dp[i], -1);
        int result=find(N-1, W, val, wt, dp);
        if(result<0)
            return 0;
        return result;
    }
    static int find(int i, int w, int[] val, int[] wt, int[][] dp){
        if(w==0)
            return 0;
        if(i==0){
                if(w>=wt[0])
                    return val[i]*(w/wt[0]);
                return (int)-1e9;
        }
        if(dp[i][w] != -1)
            return dp[i][w];
        int take=0;
        if(wt[i]<=w)
            take=val[i]+find(i, w-wt[i], val, wt, dp);
        int notTake=find(i-1, w, val, wt, dp);
        return dp[i][w]=Math.max(take, notTake);
    }
}
