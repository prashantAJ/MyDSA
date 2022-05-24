//https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#
class Solution{

	public int perfectSum(int nums[],int n, int sum) 
	{ 
	    // Your code goes here
        int[][] dp=new int[n][sum+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        int result= find(n-1, sum, nums, dp);
        return result;

	} 
	public int find(int i, int sum, int[] nums, int[][] dp){
        //Tabulation
        int[][] dp1=new int[nums.length][sum+1];
        for(int ii=0;ii<nums.length;ii++)
            dp1[ii][0]=1;
        if(nums[0]<=sum)
            dp1[0][nums[0]]=1;
        for(int j=1;j<nums.length;j++){
            for(int k=0;k<=sum;k++){
                int a=0,b=0;
                if(k-nums[j] >= 0)
                    a=dp1[j-1][k-nums[j]];
                b=dp1[j-1][k];
               dp1[j][k]=(a+b)%100000007;
            }
        }
        return dp1[nums.length-1][sum];
        /* Memoization
        if(sum==0)
            return 1;
        if(i==0){
            if(sum == nums[0])
                return 1;
            else
                return 0;
        }       
        if(dp[i][sum] != -1)
            return dp[i][sum];
        return dp[i][sum]=(find(i-1, sum-nums[i], nums, dp) + find(i-1, sum, nums, dp))%1000000007;
        */
