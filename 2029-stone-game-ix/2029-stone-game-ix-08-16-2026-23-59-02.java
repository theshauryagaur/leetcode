class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;

        int[] rem = new int[3];
        for(int i=0; i<n; i++){
            int x = stones[i] % 3;
            rem[x]++;
        }

        if((rem[0] & 1) == 0){
            return Math.min(rem[1], rem[2]) > 0;
        }

        return Math.abs(rem[1] - rem[2]) > 2;
    }
} 