class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0) return false;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i: hand){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }

        Arrays.sort(hand);
        for(int i=0; i<n; i++){
            if(freq.get(hand[i]) > 0){
                for(int j=0; j<groupSize; j++){
                    int x = freq.getOrDefault(hand[i]+j, 0);
                    if(x > 0){
                        freq.put(hand[i]+j, x-1);
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}