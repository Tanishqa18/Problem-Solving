class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int n = s.length();

        if (n < totalLen) return result;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = offset; right + wordLen <= n; right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == wordCount) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}
