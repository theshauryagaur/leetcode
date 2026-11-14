class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        Arrays.sort(words, Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        // System.out.println(Arrays.toString(words));

        for(int i=0; i<n; i++){
            String wordi = words[i];
            int ilen = wordi.length();

            for(int j=i+1; j<n; j++){
                int m = words[j].length();
                if(m - wordi.length() == 1){
                    int l=0, r=0;
                    int diff = 0;

                    while(l < ilen && r < m){
                        if(wordi.charAt(l) != words[j].charAt(r)){
                            diff++;
                            r++;
                            continue;
                        }
                        l++; r++;
                    }
                    if(r < m || diff == 1){
                        adj[i].add(j);
                    }
                }
            }
        }


        boolean[] visi = new boolean[n];
        int ans = 1;
        for(int i=0; i<n; i++){
            if(!visi[i]){
                ans = Math.max(ans, 1 + dfs(adj, i, visi));
            }
        }
        return ans;

    }

    public int dfs(List<Integer>[] adj, int i, boolean[] visi){

        int max = 0;
        for(int j : adj[i]){
            if(!visi[i]){
                max = Math.max(max, 1 + dfs(adj, j, visi));
                visi[j] = true;
            }
        }
        return max;
    }
}