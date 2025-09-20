class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int curRow = 0;
        int step = 1; 

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0) step = 1;
            else if (curRow == numRows - 1) step = -1;
            curRow += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }
}
