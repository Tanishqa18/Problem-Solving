class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond reachable range
            if (i > maxReach) {
                return false;
            }
            
            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we can reach or pass the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}
