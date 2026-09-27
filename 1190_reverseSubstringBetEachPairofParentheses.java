class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        int[] matching=new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                int open=stack.pop();
                matching[open]=i;
                matching[i]=open;
            }
        }
        StringBuilder result=new StringBuilder();
        int i=0;
        int direction=1;
        while(i>=0 && i<n){
            char ch = s.charAt(i);
            if(ch=='(' || ch ==')'){
                i=matching[i];
                direction=-(direction);
            }
            else{
                result.append(ch);
            }
            i+=direction;
        }
        return result.toString();
    }
}
