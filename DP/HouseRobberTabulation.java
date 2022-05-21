https://leetcode.com/problems/house-robber/
public int rob(int[] nums, int[] dp){
        dp[0]=nums[0];
        for(int ii=1;ii<nums.length;ii++){
            int take=nums[ii];
            if(ii-2 >= 0)
                take+=dp[ii-2];
            int notTake=dp[ii-1];
            dp[ii]=Math.max(take, notTake);
        }
        return dp[dp.length-1];
}
