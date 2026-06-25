class Solution {
    public int maxDistance(String moves) {
        int u=0, d=0, l=0, r=0;
        int und = 0;
        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            switch (c) {
                case 'U' : u++; break;
                case 'D' : d++; break;
                case 'L' : l++; break;
                case 'R' : r++; break;
                default : und++;
            }
        }
        int ver = Math.abs(u-d);
        int hor = Math.abs(l-r);

        return ver + hor + und;
    }
}