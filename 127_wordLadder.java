class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char old = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[i] = ch;

                        String next = new String(arr);

                        if (set.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    arr[i] = old;
                }
            }

            level++;
        }

        return 0;
    }
}
