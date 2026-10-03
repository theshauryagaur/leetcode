class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: times){
            int u = edge[0], v = edge[1], t = edge[2];
            adj[u].add(new int[]{v, t});
        }

        int reached = 1;

        int[] minTime = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{k,0});
        visited[k] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0], t = curr[1];

            for(int[] neig: adj[u]){
                int v = neig[0];
                int timeUV = neig[1];

                if(!visited[v] || minTime[v] > timeUV + t){
                    if(!visited[v]) reached++;

                    minTime[v] = timeUV + t;
                    visited[v] = true;
                    q.offer(new int[]{v, minTime[v]});
                }
            }
        }
        if(reached < n) return -1;
        int ans = Integer.MIN_VALUE;
        for(int i: minTime) ans = Math.max(ans, i);
        return ans;
    }
}