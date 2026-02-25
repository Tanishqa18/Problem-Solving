class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        boolean leftempty;
        boolean rightempty;
        if(flowerbed.length==1){
            if(flowerbed[0]==0&& n<=1 ){
                return true;
            }else if(flowerbed[0]==1&&n==0){
                return true;
            }else{
                return false;
            }
        }
        for (int i =0; i<len; i++){
            if(n==0){
                return true;
            }
            if(flowerbed[i] == 0){
                if(i==0){
                 leftempty=true;
                 rightempty = flowerbed[i+1] == 0;
                }else if(i==flowerbed.length-1){
                    rightempty=true;
                    leftempty =  flowerbed[i-1] == 0;
                }
                else{
                leftempty =  flowerbed[i-1] == 0;
                rightempty = flowerbed[i+1] == 0;
                }

               

                if(leftempty && rightempty) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if(n==0) return true;
        return false;
    }
}
