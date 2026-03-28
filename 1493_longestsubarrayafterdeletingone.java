class Solution {
    public int longestSubarray(int[] nums) {
       int start = 0;
       int zerocount = 0;
       int max = 0;

       for (int end =0; end<nums.length; end++){

            if(nums[end]==0){
                zerocount++;
            }
            while(zerocount>1){
                if(nums[start]==0){
                    zerocount--;
                }
                start++;
            }
            max = Math.max(max,end-start);
       } 
       return max;    
    }
}
