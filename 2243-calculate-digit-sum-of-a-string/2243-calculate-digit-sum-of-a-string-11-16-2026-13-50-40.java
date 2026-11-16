class Solution {
    public StringBuilder help(StringBuilder sb, int k){
        int n = sb.length();
        StringBuilder ans = new StringBuilder();
        int curr = 0;
        for(int i=0; i<n; i++){
            curr += (sb.charAt(i) - '0');
            if((i + 1) % k == 0){
                ans.append(String.valueOf(curr));
                curr = 0;
            }
        }
        if(n % k != 0) ans.append(String.valueOf(curr));
        return ans;
    }
    public String digitSum(String s, int k) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k){
            sb = help(sb, k);
        }

        return sb.toString();
    }
}