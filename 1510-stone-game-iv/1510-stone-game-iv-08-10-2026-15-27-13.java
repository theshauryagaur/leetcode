class Solution {
    
    public boolean winnerSquareGame(int n) {
        List<Integer> sq;
        sq = new ArrayList<Integer>();
        for(int i=1; i*i<=n; i++) sq.add(i*i);

        boolean[] canWin = new boolean[n+1];
        canWin[0] = false;
        for(int i=1; i<=n; i++){
            boolean possi = true;
            for(int j: sq){
                if(j > i) break;
                if(!canWin[i-j]) {
                    canWin[i] = true;
                    break;
                }
            }
        }

        return canWin[n];
    }
}