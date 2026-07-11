class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }
        //System.out.print(Arrays.toString(adj));

        int ans = 0;

        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                visited[i] = true;

                int nodes = 1;
                int edge=0;
            
                while(!q.isEmpty()){
                    int u = q.poll();
                    for(int v: adj[u]){
                        edge++;
                        if(!visited[v]){
                            visited[v] = true;
                            q.offer(v);
                            nodes++;
                        }
                    }
                }
                if(edge/2 == (nodes*(nodes-1))/2) ans++;
            }
        }
        return ans;
    }
}