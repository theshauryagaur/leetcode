class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        PriorityQueue<Integer> tall = new PriorityQueue<>();
        int i=0;
        for(; i<n-1; i++){
            if(heights[i+1] > heights[i]){
                tall.add(heights[i+1] - heights[i]);
                if(tall.size() > ladders){
                    int x = tall.poll();
                    if(bricks-x >= 0){
                        bricks -= x;
                    }
                    else break;
                }
            }
        }
        return i;
    }
}