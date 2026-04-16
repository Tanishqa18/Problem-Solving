class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for(int i = 0;i<32;i++){
            int bita = (a>>i) & 1;
            int bitb = (b>>i) & 1;
            int bitc = (c>>i) & 1;

            if(bitc==1){
                if (bita == 0 && bitb == 0) {
                    flips += 1;
                }
            }else {
                if (bita == 1) flips++;
                if (bitb == 1) flips++;
            }
        }
        return flips;
    }
}
