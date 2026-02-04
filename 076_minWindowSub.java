class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        int[] need = new int[128];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            if (need[c] > 0)
                count--;

            need[c]--;
            right++;

            while (count == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                need[lc]++;

                if (need[lc] > 0)
                    count++;

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}
