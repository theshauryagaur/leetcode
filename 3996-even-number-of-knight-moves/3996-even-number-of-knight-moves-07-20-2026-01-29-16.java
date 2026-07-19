class Solution {
    public boolean canReach(int[] start, int[] target) {
        int destX = target[0], destY = target[1];

        if((start[0]+start[1])%2 == (destX+destY)%2 ) return true;
        return false;
    }
}