class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();

        int l = 0, r = n-1;
        for(int i=0; i<candidates && l<=r; i++){
            front.add(costs[l++]);
            if(l <= r) back.add(costs[r--]);
        }

        long ans = 0;
        for(int i=0; i<k; i++){
            int f = front.isEmpty() ? 1000000000 : front.peek();
            int b = back.isEmpty() ? 1000000000 : back.peek();

            if(f <= b){
                ans += f;
                front.poll();
                if(l <= r) front.add(costs[l++]);
            }
            else{
                ans += b;
                back.poll();
                if(l <= r) back.add(costs[r--]);
            }
        }
        return ans;
    }
}