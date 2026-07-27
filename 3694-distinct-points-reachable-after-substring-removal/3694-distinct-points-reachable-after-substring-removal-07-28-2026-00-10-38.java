class Solution {
    public record Pair<K, V> (K key, V val){} 
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
        //System.out.print(Arrays.toString(preX));
        //System.out.print(Arrays.toString(preY));
        int ans = 0;
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();

        for(i=0; i<=n-k; i++){
            int x = preX[n]+preX[i]-preX[i+k];
            int y = preY[n]+preY[i]-preY[i+k];
            Pair cord = new Pair<>(x,y);
            if(!set.contains(cord)){
                set.add(cord);
                ans++;
            }
        }
        return ans;
    }
}