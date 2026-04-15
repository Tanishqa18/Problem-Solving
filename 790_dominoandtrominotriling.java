class Solution {
    public int numTilings(int n) {
        int MOD = 1000000007;
        if( n<=2 )return n;
        long a = 1, b = 1, c = 2;
        for(int i=3; i<=n;i++){
            long d=(2*c+a)%MOD;
            a=b;
            b=c;
            c=d;
        }
        return(int) c;
    }
}
