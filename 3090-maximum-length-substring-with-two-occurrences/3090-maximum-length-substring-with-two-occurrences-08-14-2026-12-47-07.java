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
            
            if(x <= 2){
                ans = Math.max(ans, r - l + 1);
                r++;
            }
            else{
                int left = (int) (s.charAt(l)-'a');
                while(left != c){
                    int f = freq.get(left);
                    freq.put(left, f-1);

                    l++;
                    left = (int) (s.charAt(l)-'a');
                }
                freq.put(c, 2);
                l++;

                r++;
            }
        }
        return ans;
    }
}