class Solution {
    public int removeDuplicates(int[] num) {
        if (num.length == 0) return 0;
        int k = 1;
        for (int i = 1; i<num.length; i++){
            if(num[i] != num[i-1]){
                num[k] = num[i];
                k++;
            }
        }
        return k;
    }
}
