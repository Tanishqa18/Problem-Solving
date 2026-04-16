class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(num : nums){
            result^=num;
        }
        return result;
    }
}
