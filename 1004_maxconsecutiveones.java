class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int condition = 0;

        for(int i = 0; i<nums.length; i++){
            if (nums[i] == 0){
                condition++;
            }
            if(condition>k){
                if(nums[left]==0){
                    condition--;
                }
                left++;
            }
            ans = Math.max(ans, i-left+1);
        }
        return ans;
    }
}
