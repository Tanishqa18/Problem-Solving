 class Solution {
    public int sumDigit(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int val = sumDigit(nums[i]);
            if (val==i) return i;
        }
        return -1;
    }
}
