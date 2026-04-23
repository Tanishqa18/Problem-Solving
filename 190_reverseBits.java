class Solution {
    public int reverseBits(int n) {
        int mask = 1;
        int ans = 0;
        for(int i=0;i<32;i++){
            if((mask&n)!=0){
                ans+=1<<31-i;
            }
            mask<<=1;
        }
        return ans;
    }
}
