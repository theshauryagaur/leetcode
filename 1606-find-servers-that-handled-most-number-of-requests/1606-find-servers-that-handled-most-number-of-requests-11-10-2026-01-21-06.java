class Solution {
    // public class Pair {
    //     int free;
    //     int serv;
    //     public Pair(int free, int serv){
    //         this.free = free;
    //         this.serv = serv;
    //     }
    // }
    record Pair(int free, int serv){}

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int busy = 0;
        int[] served = new int[k];

        int n = arrival.length;

        TreeSet<Pair> tasks = new TreeSet<>(  
            Comparator.comparingInt(Pair::free).thenComparing(Pair::serv)
        );

        TreeSet<Integer> free = new TreeSet<>();
        for(int i=0; i<k; i++) free.add(i);

        int mx = 0;
        int time = 0;
        for(int i=0; i<n; i++){
            time = arrival[i];

            Pair p = tasks.floor(new Pair(time, Integer.MAX_VALUE));
            while(p != null){
                tasks.remove(p);
                free.add(p.serv);
                busy--;
                p = tasks.floor(new Pair(time, Integer.MAX_VALUE));
            }

            if(busy == k) continue;

            Integer assignedTo = free.ceiling(i%k);
            if(assignedTo == null) assignedTo = free.first();

            busy++;
            tasks.add(new Pair(time + load[i], assignedTo));
            free.remove(assignedTo);
            if(++served[assignedTo] > mx) mx = served[assignedTo];
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            if(served[i] == mx) ans.add(i);
        }

        return ans;
    }
}