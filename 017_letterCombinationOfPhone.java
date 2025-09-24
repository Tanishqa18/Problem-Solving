import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] phoneMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(res, phoneMap, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, String[] phoneMap, String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(res, phoneMap, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
