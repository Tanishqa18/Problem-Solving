class Solution {
    Set<String> result = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftremove=0;
        int rightremove=0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                leftremove++;
            }
            else if(ch==')'){
                if(leftremove>0){
                    leftremove--;
                }
                else{
                    rightremove++;
                }
            }
        }
        backtrack(s,0,leftremove,rightremove,0,"");
        return new ArrayList<>(result);
    }
    private void backtrack(
        String s,
        int index,
        int leftremove,
        int rightremove,
        int balance,
        String current
    ){
        if(balance<0){
            return;
        }
        if(index==s.length()){
            if(leftremove==0 && rightremove==0 && balance == 0){
                result.add(current);
            }
            return;
        }
        char ch = s.charAt(index);

        if(ch=='('){
            if(leftremove>0){
                backtrack(
                    s,index+1,leftremove-1,rightremove,balance,current
                );
            }
            backtrack(
                 s,
                index + 1,
                leftremove,
                rightremove,
                balance + 1,
                current + ch
            );
        }
        else if(ch==')'){
            if (rightremove > 0) {
                backtrack(
                    s,
                    index + 1,
                    leftremove,
                    rightremove - 1,
                    balance,
                    current
                );
            }
            if (balance > 0) {
                backtrack(
                    s,
                    index + 1,
                    leftremove,
                    rightremove,
                    balance - 1,
                    current + ch
                );
            }
        }
        else {
            backtrack(
                s,
                index + 1,
                leftremove,
                rightremove,
                balance,
                current + ch
            );
        }
    }
}
