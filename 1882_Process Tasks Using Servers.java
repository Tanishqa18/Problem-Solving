class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                free.offer(new int[]{
                    (int) s[1], (int) s[2]
                });
            }

            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();
                    free.offer(new int[]{
                        (int) s[1], (int) s[2]
                    });
                }
            }

            int[] s = free.poll();

            int weight = s[0];
            int index = s[1];

            ans[j] = index;

            busy.offer(new long[]{
                time + tasks[j], weight, index
            });
        }

        return ans;
    }
}
