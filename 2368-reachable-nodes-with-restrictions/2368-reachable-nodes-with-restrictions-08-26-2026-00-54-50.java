class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: restricted) set.add(i);

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visi = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            visi[curr] = true;

            for(int v: adj[curr]){
                if(!visi[v]){
                    visi[v] = true;
                    if(!set.contains(v)){
                        ans++;
                        q.offer(v);
                    }
                }
            }
        }
        return ans+1;
    }
}