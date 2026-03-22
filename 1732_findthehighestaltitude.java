class Solution {
    public int largestAltitude(int[] gain) {
        int current=0;
        int maxaltitude = 0;
        for (int i= 0; i< gain.length;i++){
            current += gain[i];
            maxaltitude =Math.max(maxaltitude, current);
        }return maxaltitude;
    }
}
