class Solution {
    public int maxSubArray(int[] nums) {
        int local=0, max=Integer.MIN_VALUE; 
        for(int i=0;i<nums.length;i++){
            local+=nums[i];
            if(local>max)
                max=local;
            if(local<0)
                local=0;
        }
        return max;
    }
}
