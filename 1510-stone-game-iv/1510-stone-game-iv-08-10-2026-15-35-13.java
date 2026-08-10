class Solution {
    static List<Integer> sq;
    static boolean[] canWin;
    static{   
        sq = new ArrayList<Integer>();
        for(int i=1; i*i<=(1e5); i++) sq.add(i*i);

        canWin = new boolean[100001];
        canWin[0] = false;
        for(int i=1; i<=100000; i++){
            boolean possi = true;
            for(int j: sq){
                if(j > i) break;
                if(!canWin[i-j]) {
                    canWin[i] = true;
                    break;
                }
            }
        }
    }
    public boolean winnerSquareGame(int n) {
        return canWin[n];
    }
}