class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int m = arr1.length;
        int n = arr2.length;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int ans = 0;
        for(int i=0; i<m; i++){
            int x = arr1[i];
            boolean candi = true;
            for(int j=0; j<n; j++){
                if(Math.abs(x - arr2[j]) <= d) {
                    candi = false;
                    break;
                }
            }
            if(candi) ans++;
        }

        return ans;
    }
}