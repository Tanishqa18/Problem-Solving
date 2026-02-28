class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int i = 0;

        while(i < chars.length){
            char current = chars[i];
            int count = 0;
             while (i<chars.length && chars[i] == current){
                i++;
                count++;
             }
             chars[write++] = current;
             if(count>1){
                String c = String.valueOf(count);
                for(char ch: c.toCharArray()){
                    chars[write++] = ch;
                }
             }
        }
        return write;
        
    }
}
