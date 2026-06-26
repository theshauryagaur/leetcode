class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            long sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                int lastDigit =(int) (sum%10);
                if(lastDigit == x){
                    String s = Long.toString(sum);
                    int firstDigit = (int) (s.charAt(0) - '0');
                    if(firstDigit == x) ans++;
                }
            }
            
        }
        return ans;
    }
}