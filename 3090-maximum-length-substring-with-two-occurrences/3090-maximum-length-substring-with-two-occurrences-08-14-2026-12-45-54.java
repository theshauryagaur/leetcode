class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        int l = 0, r = 0;
        while(r < n){
            int c = (int) (s.charAt(r) - 'a');
            int x = freq.getOrDefault(c, 0) + 1;
            freq.put(c , x);

            while(freq.get(c) > 2){
                int left = (int) (s.charAt(l) - 'a');
                freq.put(left, freq.get(left) - 1);
                l++;
            }
            
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}