class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0 , j=n-1;

        for(int c = 0 ; c<candidates && i<=j; c++){
            left.offer(costs[i++]);
        }

        for(int c = 0; c<candidates && i<=j; c++){
            right.offer(costs[j--]);
        }

        long total = 0;

        for (int hire = 0; hire<k; hire++){
            int leftmin = left.isEmpty()? Integer.MAX_VALUE : left.peek();
            int rightmin = right.isEmpty()? Integer.MAX_VALUE : right.peek();
            if(leftmin<= rightmin){
                total +=left.poll();

                if(i<=j){
                    left.offer(costs[i++]);
                }
            }
            else{
                total +=right.poll();
                if(i<=j){
                    right.offer(costs[j--]);
                }
            }
        }
        return total;
    }
}
