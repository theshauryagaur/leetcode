class Solution {
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] prefixGcd = new int[n];
        int max;
        prefixGcd[0] = max = nums[0];
        for(int i=1; i<n; i++){
            max = Math.max(max, nums[i]);
            
            prefixGcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        int l=0, r=n-1;
        while(l < r){
            ans += gcd(prefixGcd[l], prefixGcd[r]);
            
            l++;
            r--;
        }
        return ans;
    }
}