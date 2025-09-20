class Router {
    class Pair{
        int a;int b;int c;
        public Pair(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    HashMap<String,HashSet<Integer>>freq=new HashMap<>();
    HashMap<Integer,List<Integer>>h=new HashMap<>();
    Queue<Pair>q=new LinkedList<>();
    int count=0;
    int total=0;
    public Router(int memoryLimit) {
        total=memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String s=source+","+destination;
        if(freq.containsKey(s) && freq.get(s).contains(timestamp)){
            return false;
        }
        if(freq.containsKey(s)==false){
            freq.put(s,new HashSet<Integer>());
        }
        freq.get(s).add(timestamp);
        q.add(new Pair(source,destination,timestamp));
        if(h.containsKey(destination)==false){
            List<Integer>ooo=new ArrayList<>();
            h.put(destination,ooo);
        }
        h.get(destination).add(timestamp);

        if(q.size()>total){
            Pair p=q.poll();
            int y=p.b;
            h.get(y).remove(0);
            String s1=p.a+","+p.b;
            freq.get(s1).remove(p.c);
        }
        return true;
    }
    
    public int[] forwardPacket() {
        if(q.size()==0){
            return new int[0];
        }
        
  Pair p=q.poll();
            int y=p.b;
            h.get(y).remove(0);
            String s1=p.a+","+p.b;
            freq.get(s1).remove(p.c);

    int pp[]=new int[3];
        pp[0]=p.a;
        pp[1]=p.b;
        pp[2]=p.c;
        return pp;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
     if(h.containsKey(destination)==false){
         return 0;
     }   
        List<Integer>l=h.get(destination);
        int i=0;
        int ans=-1;
        int j=l.size()-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(l.get(mid)>=startTime){
                ans=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }

        i=0;
        int ans1=-1;
        j=l.size()-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(l.get(mid)<=endTime){
                ans1=mid;
                i=mid+1;
            }else{
                j=mid-1;
            }
        }

        if(ans==-1 || ans1==-1){
            return 0;
        }
        return ans1-ans+1;        
    }
}
