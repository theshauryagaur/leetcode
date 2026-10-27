class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        for(int i=0; i<m; i++){
            char[] s = new char[n];
            for(int j=0; j<n; j++){
                if(i == 0 || j == n-1){
                    s[j] = '.';
                }
                else s[j] = '#';
            }
            ans[i] = new String(s);
        }

        return ans;
    }
}