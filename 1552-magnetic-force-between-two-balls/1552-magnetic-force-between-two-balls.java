class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int l = 1;
        int r = position[n-1]-position[0];
        
        if(m == 2) return position[n-1]-position[0];

        int ans = 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(isValid(position, mid, m)){
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }

    public boolean isValid(int[] pos, int dis, int m){
        int n = pos.length;
        int l = pos[0];
        int placed = 1;

        for(int i=1; i<n; i++){
            if(pos[i]-l >= dis){
                placed++;
                l = pos[i];
            }
            if(placed == m) return true;
        }

        return placed >= m ? true : false;
    }
}