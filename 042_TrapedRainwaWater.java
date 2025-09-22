class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n<3) return 0;
        int l = 0, r=n-1;
        int leftmax=0, rightmax=0, water=0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftmax) {
                    leftmax = height[l];
                }    
                else water += leftmax - height[l];
                l++;
            } else {
                if (height[r] >= rightmax) rightmax = height[r];
                else water += rightmax - height[r];
                r--;
            }
        }
        return water;
    }
}
