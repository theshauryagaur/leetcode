class Solution {
    public int findCenter(int[][] edges) {
        int centre1 = edges[0][0];
        int centre2 = edges[0][1];

        if(edges[1][0] == centre1) return centre1;
        if(edges[1][0] == centre2) return centre2;
        if(edges[1][1] == centre1) return centre1;
        if(edges[1][1] == centre2) return centre2;

        return 0;
    }
}