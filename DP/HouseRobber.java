class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return rob(nums.length-1, nums, dp);
    }
    public int rob(int i, int[] nums, int[] dp){
        int l=Integer.MIN_VALUE, r=Integer.MIN_VALUE;
        if(i==0)
            return nums[i];
        if(i<0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        l=nums[i]+rob(i-2, nums, dp);
        r=rob(i-1, nums, dp);
        return dp[i]=Math.max(l,r);
    }
}
