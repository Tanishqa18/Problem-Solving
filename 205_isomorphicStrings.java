class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] maps=new int[256];
        int[] mapt=new int[256];
        for( int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(maps[ch1]!= mapt[ch2]){
                return false;
            }
            maps[ch1]=i+1;
            mapt[ch2]=i+1;
        }
        return true;
    }
}
