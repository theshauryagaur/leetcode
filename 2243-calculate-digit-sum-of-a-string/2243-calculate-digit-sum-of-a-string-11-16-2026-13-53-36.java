class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        if(n <= k) return s;

        StringBuilder ans = new StringBuilder();
        int curr = 0;
        for(int i=0; i<n; i++){
            curr += (s.charAt(i) - '0');
            if((i + 1) % k == 0){
                ans.append(String.valueOf(curr));
                curr = 0;
            }
        }
        if(n % k != 0) ans.append(String.valueOf(curr));

        return digitSum(String.valueOf(ans), k);
    }
}