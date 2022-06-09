class Solution {
    public int findDuplicate(int[] nums) {
      //slow fast pointer for cycle finding  
      int fast=nums[0], slow=nums[0];
        do{
            fast=nums[nums[fast]];
            slow=nums[slow];
        }
        while(slow!=fast);
      //To find duplicate (Intersection point)  
      fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
