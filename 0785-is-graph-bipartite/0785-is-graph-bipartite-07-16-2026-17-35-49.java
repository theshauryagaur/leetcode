class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        for(int i=0; i<n; i++){
            Queue<Integer> q = new ArrayDeque<>();

            boolean[] visited = new boolean[n];
            int[] parent = new int[n];
            int[] dist = new int[n];

            q.offer(i);
            //parent[i] = -1;
            visited[i] = true;

            while(!q.isEmpty()){
                int u = q.poll();
                int distU = dist[u];
                int parentU = parent[u];

                for(int v : graph[u]){
                    if(!visited[v]){
                        q.offer(v);
                        visited[v] = true;
                        parent[v] = u;
                        dist[v] = distU + 1;
                    } 
                    else {
                        if(v != parentU && ((dist[u]+dist[v]+1)%2 == 1)) {
                            // System.out.print(v);
                            return false;
                        }
                    } 
                }
            }
        }

        return true;
    }
}