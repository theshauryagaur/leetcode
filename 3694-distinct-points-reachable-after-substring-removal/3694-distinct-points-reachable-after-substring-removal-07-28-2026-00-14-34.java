class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        if(n == k) return 1;

        int[] preX = new int[n+1];
        int[] preY = new int[n+1];
        int i=0;
        for(char c: s.toCharArray()){
            preY[i+1] = preY[i];
            preX[i+1] = preX[i];

            if(c == 'U') preY[i+1]++;
            else if(c == 'D') preY[i+1]--;
            else if(c == 'R') preX[i+1]++;
            else if(c == 'L') preX[i+1]--;
            i++;
        }

        int ans = 0;
        HashSet<String> set = new HashSet<>();

        for(i=0; i<=n-k; i++){
            int x = preX[n]+preX[i]-preX[i+k];
            int y = preY[n]+preY[i]-preY[i+k];
            String cord = x+","+y;
            if(!set.contains(cord)){
                set.add(cord);
                ans++;
            }
        }
        return ans;
    }
}