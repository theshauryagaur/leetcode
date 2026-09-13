class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> one1 = new ArrayList<>();
        List<int[]> one2 = new ArrayList<>();
        
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j] == 1) one1.add(new int[]{i,j});
                if(img2[i][j] == 1) one2.add(new int[]{i,j});
            }
        }

        HashSet<Integer> set = new HashSet<>(); //already used a translation
        for(int i=0; i<one1.size(); i++){
            for(int j=0; j<one2.size(); j++){
                int r = one2.get(j)[0] - one1.get(i)[0];
                int c = one2.get(j)[1] - one1.get(i)[1];

                if(set.contains(r*1000+c)){
                    continue;
                }

                set.add(r*1000+c);
                int overlap = 0;

                for(int k=0; k<one1.size(); k++){
                    int x = one1.get(k)[0] + r;
                    int y = one1.get(k)[1] + c;
                    if(x>=0 && x<n && y>=0 && y<n && img2[x][y] == 1) overlap++;
                }
                ans = Math.max(ans, overlap);

            }
        }

        return ans;
    }
}