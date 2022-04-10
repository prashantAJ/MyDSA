//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
//Example :
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if(nums.length<3)
            return res;
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2)
        {
            if(nums[i]>0) break;
            int j=i+1;    
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                //while loop to avoid duplicates
                if(sum>=0) while(nums[k]==nums[--k]  && k>j);
                //while loop to avoid duplicates
                if(sum<=0) while(nums[j]==nums[++j] && j<k);
            }
            //while loop to avoid duplicates
            while(nums[i]==nums[++i]  && i < nums.length-2);
        }
        return res;
    }
}
