class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] invo : invocations){
            adj[invo[0]].add(invo[1]);
        }

        HashSet<Integer> sus = new HashSet<>();
        sus.add(k);
        boolean[] visi = new boolean[n];
        visi[k] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v: adj[curr]){
                if(!visi[v]){
                    sus.add(v);
                    visi[v] = true;
                    q.offer(v);
                }
            }
        }

        boolean canRemove = true;
        for(int i=0; i<n; i++){
            if(!visi[i]){
                for(int v: adj[i]){
                    if(visi[v]){
                        canRemove = false;
                        break;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(canRemove){
            for(int i=0; i<n; i++){
                if(!visi[i]) ans.add(i);
            }
        }
        else{
            for(int i=0; i<n; i++){
                ans.add(i);
            }
        }
        return ans;
    }
}