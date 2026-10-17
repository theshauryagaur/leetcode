class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] pair = new int[n][2];
        for(int i=0; i<n; i++){
            int x = nums[i];
            int sum = 0;
            while(x != 0){
                sum += x%10;
                x /= 10;
            }
            pair[i] = new int[]{i, sum};
        }

        Arrays.sort(pair, (a, b) -> {
            if(a[1] != b[1]) return a[1]-b[1];
            else return nums[a[0]] - nums[b[0]];
        });

        boolean[] visi = new boolean[n];
        int swaps = 0;
        for(int i=0; i<n; i++){
            if(visi[i] || pair[i][0] == i) continue;

            int cycle = 0;
            int j = i;
            while(!visi[j]){
                visi[j] = true;

                j = pair[j][0];
                cycle++;
            }

            if(cycle > 1) swaps += cycle - 1;
        }
        return swaps;
    }
}