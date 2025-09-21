class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
