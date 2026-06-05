class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int total = 1<<k;;

        if( (n-k+1) < total ) return false;
        
        int codes = (int) Math.pow(2, k);
        Set<String> set = new HashSet<>();
        for(int i = 0; i <= n - k; i++){
            String str = s.substring(i, i+k);
            set.add(str);
        }
        return set.size() == codes;
    }
}