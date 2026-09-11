class Solution {
    
    public int totalNumbers(int[] digits) {
        int n = digits.length;

        int[] cnt = new int[11];
        for(int i: digits) cnt[i]++;

        int ans = 0;
        for(int i=1; i<=9; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=8; k+=2){
                    if(cnt[i] > 0 && cnt[j] > (i == j ? 1 : 0) && cnt[k] > (i == k ? 1 : 0) + (j == k ? 1 : 0)) ans++;
                }
            }
        }
        return ans;
    }
}