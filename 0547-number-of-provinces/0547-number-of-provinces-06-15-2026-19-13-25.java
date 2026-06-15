class Solution {
    public void dfsHelper(int node, int[][] adj, boolean[] visited){
        visited[node] = true;

        for(int j=0; j<adj[0].length; j++) {
            if(adj[node][j] == 1 && !visited[j]) {
                dfsHelper(j, adj, visited);
            }
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        // int visited = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans++;
                dfsHelper(i, isConnected, visited);
            }
        }
        return ans;
    }
}