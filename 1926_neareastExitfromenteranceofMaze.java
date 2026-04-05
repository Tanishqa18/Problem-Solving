class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n = maze[0].length;

        Queue<int[]> queue =new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});

        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for(int i = 0;i<size;i++){
                int[] curr = queue.poll();
                for(int[] d: dirs){
                    int r = curr[0]+d[0];
                    int c = curr[1]+d[1];

                    if(r>=0 && r<m && c>=0 && c<n && c<n && maze[r][c]=='.'){
                        if(r==0 || c==0 || r==m-1 || c==n-1){
                            return steps;
                        }
                        queue.offer(new int[] {r,c});
                        maze[r][c] = '+';
                    }
                }
            }
        }
        return -1;
    }
}
