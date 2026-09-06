class Solution {
    public int countGroups(int[] pos, int[] speed, int dist) {
        int n = pos.length;

        int[] groupSpeed = new int[n];
        int group = 0;

        int rightSpeed = speed[0];
        for(int i=1; i<n; i++){
            if(pos[i] - pos[i-1] <= dist){
                rightSpeed = speed[i];
            }
            else{
                groupSpeed[group++] = rightSpeed;
                rightSpeed = speed[i];
            }
        }

        groupSpeed[group++] = rightSpeed;

        int ans = 0;
        int minSp =  Integer.MAX_VALUE;

        for(int i=group-1; i>=0; i--){
            if(groupSpeed[i] <= minSp){
                ans++;
                minSp = groupSpeed[i];
            }
        }

        return ans;
    }
}
