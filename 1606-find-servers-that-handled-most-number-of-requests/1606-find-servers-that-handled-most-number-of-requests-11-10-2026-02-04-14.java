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
        int[] freeTime = new int[k];
        Arrays.fill(freeTime, Integer.MAX_VALUE);

        int n = arrival.length;

        PriorityQueue<Integer> tasks = new PriorityQueue<>((a,b) -> {
            if(freeTime[a] != freeTime[b]) return Integer.compare(freeTime[a], freeTime[b]);

            return a - b;
        });

        TreeSet<Integer> free = new TreeSet<>();
        for(int i=0; i<k; i++) free.add(i);

        int mx = 0;
        int time = 0;
        for(int i=0; i<n; i++){
            time = arrival[i];

            while (!tasks.isEmpty() && freeTime[tasks.peek()] <= time) {
                int finishedServer = tasks.poll();
                free.add(finishedServer);
                busy--;
            }

            if(busy == k) continue;

            Integer assignedTo = free.ceiling(i%k);
            if(assignedTo == null) assignedTo = free.first();

            busy++;
            freeTime[assignedTo] = time + load[i];
            
            tasks.add(assignedTo);

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