class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList();
        Arrays.sort(nums);
        int size=nums.length;
        if(size<4)
            return result;
        for(int i=0; i<=size-4; i++){
            for(int j=i+1; j<=size-3; j++){
                int value=target-nums[i]-nums[j];
                int k=j+1, l=size-1;
                while(k<l){
                    int sum=nums[k]+nums[l];
                    if(sum==value){
                        result.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        while(i+1<=size-4 && nums[i]==nums[i+1])
                            i++;
                        while(j+1<=size-3 && nums[j]==nums[j+1])
                            j++;
                        while(k+1<l && nums[k]==nums[k+1])
                            k++;
                        while(l-1>k && nums[l]==nums[l-1])
                            l--;
                        k++;
                        l--;
                    }
                    else if(sum<value){
                        while(k+1<=l && nums[k]==nums[k+1])
                            k++;
                        k++;
                    }
                    else{
                        while(l-1>=k && nums[l]==nums[l-1])
                            l--;
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
