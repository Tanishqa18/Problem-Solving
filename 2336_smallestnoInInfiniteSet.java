class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> pq;
    private HashSet<Integer> set;

    public SmallestInfiniteSet() {
        current = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!pq.isEmpty()) {
            int num = pq.poll();
            set.remove(num);
            return num;
        }
        
        return current++;
    }
    
    public void addBack(int num) {
        if (num < current && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}
