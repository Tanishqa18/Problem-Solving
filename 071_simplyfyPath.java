class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String p : parts) {

            if (p.equals("") || p.equals(".")) {
                continue;
            }

            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder ans = new StringBuilder();

        for (String s : stack) {
            ans.append("/").append(s);
        }

        return ans.toString();
    }
}
