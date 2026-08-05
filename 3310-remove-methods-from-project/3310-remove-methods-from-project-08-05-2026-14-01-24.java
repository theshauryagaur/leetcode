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
        // HashSet<Integer> visi = new HashSet<>();
        // visi.add(k);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v: adj[curr]){

                // System.out.println(v);
                if(!sus.contains(v)){
                    sus.add(v);
                    // visi.add(v);
                    q.offer(v);
                }
            }
        }
        // for(int i:sus) System.out.println(i);

        boolean canRemove = true;
        for(int i=0; i<n; i++){
            if(!sus.contains(i)){
                for(int v: adj[i]){
                    if(sus.contains(v)){
                        canRemove = false;
                        break;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(canRemove){
            for(int i=0; i<n; i++){
                if(!sus.contains(i)) ans.add(i);
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