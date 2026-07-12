class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            int x = bombs[i][0];
            int y = bombs[i][1];
            int r = bombs[i][2];

            for(int j=i+1; j<n; j++){
                long X = (long) Math.pow(bombs[j][0]-x, 2);
                long Y = (long) Math.pow(bombs[j][1]-y, 2);

                if( X + Y <= (long) r*r){
                    adj.get(i).add(j);
                }
                if( X + Y <= (long) Math.pow(bombs[j][2],2) ){
                    adj.get(j).add(i);
                }
            }
        }

        int ans = -1;

        for(int i=0; i<n; i++){
            boolean[] visited = new boolean[n];
            int len = 1;

                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                    visited[i] = true;
                
                while(!q.isEmpty()){
                    int curr = q.poll();
                    
                    for(int v:adj.get(curr)){

                        if(!visited[v]){
                            q.offer(v);
                            visited[v]= true;

                            len++;
                        }
                    }

                }
            ans = Math.max(len, ans);
        }

        return ans;
    }
}