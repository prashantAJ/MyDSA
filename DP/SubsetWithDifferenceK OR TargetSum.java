class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i=0; i<nums.length; i++)
            total+=nums[i];
        int dp[][]=new int[nums.length][total+1];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], -1);
        return find(nums.length-1, 0, nums, target, total, dp);
    }
    int find(int i, int sum, int[] nums, int target, int total, int[][] dp){
        if(i==0){
            if(sum-(total-sum) == target && nums[0]==0)
                return 2;
            else if(sum-(total-sum) == target || (sum+nums[0])-(total-(sum+nums[0])) == target)
                return 1;
            else
                return 0;
        }
        if(dp[i][sum] != -1)
            return dp[i][sum];
        int plus=0;        
        plus+=find(i-1, sum+nums[i], nums, target, total, dp);
        int minus=find(i-1, sum, nums, target, total, dp);
        return dp[i][sum]=plus+minus;
    }
}
