class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited=new boolean[n*n+1];
        queue.offer(1);
        visited[1]=true;
        int moves=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-- >0){
                int curr=queue.poll();
                if(curr == n*n){
                    return moves;
                }
                for(int dice=1;dice<=6 && curr+dice<=n*n;dice++){
                    int next=curr+dice;
                    int[] pos=getPosition(next,n);
                    int r=pos[0];
                    int c=pos[1];
                    if(board[r][c]!= -1){
                        next = board[r][c];
                    }
                    if(!visited[next]){
                        visited[next]=true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private int[] getPosition(int num,int n){
        int rowFromBottom = (num-1)/n;
        int row=n-1-rowFromBottom;
        int rem=(num-1)%n;
        int col;
        if(rowFromBottom%2==0)
            col=rem;
        else
            col=n-1-rem;
        return new int[]{row,col};
    }
}
