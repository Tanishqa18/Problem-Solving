class Solution {
    public boolean closeStrings(String word1, String word2) {

        // Step 1: Length check
        if (word1.length() != word2.length()) {
            return false;
        }

        // Step 2: Frequency arrays
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Step 3: Same characters check
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) ||
                (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Step 4: Sort frequencies
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // Step 5: Compare
        return Arrays.equals(freq1, freq2);
    }
}
