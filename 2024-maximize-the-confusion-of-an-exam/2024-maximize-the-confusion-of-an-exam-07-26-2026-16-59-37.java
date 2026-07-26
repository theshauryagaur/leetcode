class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int t=0, f=0;
        int l=0, r=0;
        char st = answerKey.charAt(l);
        int ans = 1;
        while(r < n){
            if(answerKey.charAt(r) == 'T') t++;
            else f++;

            int diff = Math.min(t,f);
            if(diff <= k){
                ans = Math.max(r-l+1, ans);
            }
            if(diff > k){
                if(st == 'T') t--;
                else f--;
                l++;
                st = answerKey.charAt(l);
            }
            r++;
        }
        return ans;
    }
}