class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        HashMap<Integer,Integer>[] dist = new HashMap[n];
        for(int i=0; i<n; i++){
            //Arrays.fill(dist, new HashMap<Integer, Integer>());
            dist[i] = new HashMap<Integer,Integer>();
        }

        int ans = 0;        

        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];
            for(int j=i+1; j<n; j++){
                int dis = (int) Math.pow(points[j][0]-x, 2) + (int) Math.pow(points[j][1]-y, 2);
                int freq1 = dist[i].getOrDefault(dis, 0);
                int freq2 = dist[j].getOrDefault(dis, 0);
                ans += (freq1+freq2)*2;
                dist[i].put(dis, freq1+1);
                dist[j].put(dis, freq2+1);
            }
        }

        return ans;
    }
}