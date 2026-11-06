class Solution {
    public record Point(int type, int pt, int s){}
    // 0 -> log st
    // 2 -> log st + x
    // 1 -> queries
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] ans = new int[queries.length];

        List<Point> v = new ArrayList<>();
        for(int i=0; i<logs.length; i++){
            v.add(new Point(0, logs[i][1], logs[i][0]));
            v.add(new Point(2, logs[i][1] + x, logs[i][0]));
        }
        
        for(int i=0; i<queries.length; i++){
            v.add(new Point(1, queries[i], i));
        }

        Collections.sort(v, (u1, u2) -> {
            if(u1.pt() != u2.pt) return Integer.compare(u1.pt(), u2.pt());
            return Integer.compare(u1.type(), u2.type());
        });

        int[] req = new int[n+1];
        int active = 0;

        for(Point p : v){
            int type = p.type();
            int pt = p.pt();
            int s = p.s();

            if(type == 0){
                if(req[s] == 0) active++;
                req[s]++;
            }
            else if(type == 2){
                int freq = req[s];
                if(freq == 1){
                    active--;
                }
                req[s]--;
            }

            else if(type == 1){
                ans[s] = n - active;
            }
        }
        return ans;
    }
}