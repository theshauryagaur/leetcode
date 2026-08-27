class Solution {
    HashSet<Integer> set;
    List<Integer>[] adj;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int ans = 0;
        set = new HashSet<>();
        for(int i: restricted) set.add(i);

        adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();

        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visi = new boolean[n];
        visi[0] = true;
        return 1 + help(visi, 0);
    }
    public int help(boolean[] visi, int curr){
        int ans = 0;
        for(int v: adj[curr]){
            if(!visi[v] && !set.contains(v)){
                visi[v] = true;
                ans += 1 + help(visi,  v);   
            }
        }
        return ans;
    }
}