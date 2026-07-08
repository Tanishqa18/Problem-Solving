class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene))
            return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        char[] genes = {'A', 'C', 'G', 'T'};

        int mutations = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String curr = queue.poll();

                if (curr.equals(endGene))
                    return mutations;

                char[] arr = curr.toCharArray();

                for (int i = 0; i < 8; i++) {

                    char old = arr[i];

                    for (char ch : genes) {

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

            mutations++;
        }

        return -1;
    }
}
