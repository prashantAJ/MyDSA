class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct=1, suffixProduct=1, max=Integer.MIN_VALUE; 
      //Calculate product from (start to end) & (end to start) of an array, whenever product goes 0 make it 1.  
      for(int i=0, j=nums.length-1;i<nums.length && j>=0;i++, j--){
            if(prefixProduct==0)
                prefixProduct=1;
            if(suffixProduct==0)
                suffixProduct=1;
            prefixProduct*=nums[i];
            suffixProduct*=nums[j];
            max=Math.max(max, Math.max(prefixProduct, suffixProduct));
        }
        return max;
    }
}
