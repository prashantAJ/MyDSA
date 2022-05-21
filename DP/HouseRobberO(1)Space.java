public int rob(int[] nums){
        int prev=nums[0];
        int prev2=0;
        for(int x=1;x<nums.length;x++){
            int take=nums[x];
            if(x-2 >= 0)
                take+=prev2;
            int notTake=prev;
            int current=Math.max(take, notTake);
            prev2=prev;
            prev=current;
        }
        return prev;
}
