import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] window = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Create a window of size p.length()
        for (int i = 0; i < s.length(); i++) {

            window[s.charAt(i) - 'a']++;

            // Remove the character outside the window
            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            // Check if the window is an anagram
            if (Arrays.equals(pCount, window)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
