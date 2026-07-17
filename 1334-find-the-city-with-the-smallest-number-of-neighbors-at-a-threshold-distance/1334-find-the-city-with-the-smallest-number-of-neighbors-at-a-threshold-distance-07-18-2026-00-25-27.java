class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INT_MAX = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u].add(new int[]{v, wt});
            adj[v].add(new int[]{u, wt});
        }

        int[] reachable = new int[n];

        // for(int i=0; i<n; i++){
        //     for (int[] arr : adj[i]) {
        //         System.out.println(Arrays.toString(arr));
        //     }
        // }

        for(int i=0; i<n; i++){
            int[] dist = new int[n];
            Arrays.fill(dist, INT_MAX);
            dist[i] = 0;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);

            boolean[] visited = new boolean[n];
            while(!q.isEmpty()){
                int u = q.poll();

                for(int[] edge: adj[u]){
                    int v = edge[0];
                    int wt = edge[1];

                    if(dist[v] > dist[u]+wt){
                        dist[v] = dist[u]+wt;
                        q.offer(v);

                        if(!visited[v] && dist[v] <= distanceThreshold){
                            reachable[i]++;
                            visited[v] = true;
                            
                        } 
                    }
                }

            }

        }
        
        //System.out.print(Arrays.toString(reachable));
        
        int minCity = n;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(reachable[i] <= minCity){
                minCity = reachable[i];
                ans = i;
            }
        }

        return ans;
    }
}