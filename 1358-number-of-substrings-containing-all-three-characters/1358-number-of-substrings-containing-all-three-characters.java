class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();
        int cnt = 0;

        int[] ind = new int[3];
        Arrays.fill(ind,-1);
        
        for(int i=0; i<n; i++){
            ind[s.charAt(i)-'a'] = i;

            cnt += Math.min(ind[0],Math.min(ind[1], ind[2])) + 1;
        }
        return cnt;
    }
}