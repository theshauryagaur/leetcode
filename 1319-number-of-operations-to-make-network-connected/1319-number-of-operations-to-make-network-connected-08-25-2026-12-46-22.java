class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] con: connections){
            int u = con[0], v = con[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int extra = 0;
        int network = 0;

        boolean[] visi = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visi[i]){
                network++;
                int edges = 0;
                int comp = 0;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                visi[i] = true;
                while(!q.isEmpty()){
                    int u = q.poll();
                    comp++;
                    edges += adj[u].size();

                    for(int v: adj[u]){
                        if(!visi[v]){
                            q.offer(v);
                            visi[v] = true;

                        }
                    }
                }
                edges /= 2;
                extra += edges - (comp-1);

            }
        }
        if(network > extra+1) return -1;
        return network-1;
    }
}