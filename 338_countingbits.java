class Solution {
    public int[] countBits(int n) {
        int[] num = new int[n+1];
        for(int i =1;i<=n;i++){
            num[i] = num[i>>1] +(i & 1);
        }
        return num;
    }
}
