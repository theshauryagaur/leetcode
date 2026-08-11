class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: flights){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(new int[]{v, edge[2]});
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src, 0});
        int stops = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-->0){
                int[] curr = q.poll();
                int u = curr[0];
                int costU = curr[1];
                
                for(int[] to: adj[u]){
                    int v = to[0];
                    int costV = costU + to[1];
                    if(stops <= k+1){
                        if(v == dst){
                            minCost[dst] = Math.min(minCost[dst], costV);
                        }
                        if(costV < minCost[v]){
                            minCost[v] = costV;
                            q.offer(new int[]{v, costV});
                        }
                    }
                }
            }
            // else{
            //     break;
            // }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}