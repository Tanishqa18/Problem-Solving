import java.util.Stack;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            else if (ch == '[') {  
                numberStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = new StringBuilder(); 
            }

            else if (ch == ']') {   
                int repeat = numberStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(currentString);
                }

                currentString = prev;
            }

            else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
