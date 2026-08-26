class Solution {
    public String lexiSmall(String a, String b){
        int n = a.length(), m = b.length();
        if(n < m) return a;
        if(n > m) return b;

        for(int i=0; i<n; i++){
            if(a.charAt(i)-'0' == b.charAt(i)-'0') continue;
            if(a.charAt(i)-'0' < b.charAt(i)-'0') return a;
            else return b;
        }
        return a;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int ones = 0;
        for(int i=0; i<n; i++) ones += s.charAt(i)-'0';
        if(ones < k) return "";

        String ans = s;
        int curr = 0;
        int l = 0, r = 0;
        while(r < n){
            if(s.charAt(r) == '1'){
                curr++;

                if(curr > k){
                    l++;
                    while(l < n && s.charAt(l) == '0'){
                        l++;
                    }
                    curr--;
                }
            }
            if(curr == k){
                ans = lexiSmall(ans, s.substring(l,r+1));
            }
            r++;
            if(s.charAt(l) == '0') l++;
        }
        return ans;
    }
}