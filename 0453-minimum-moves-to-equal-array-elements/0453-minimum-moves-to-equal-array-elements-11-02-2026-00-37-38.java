class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int ans = 0;
        for(int i=1; i<n; i++) ans += nums[i] - nums[0];

        return ans;
    }
}
// NOT CHECKED
    // HashSet<Integer> set = new HashSet<>();
    // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collectons.reverseOrder());

    // int max = Integer.MIN_VALUE;
    // int min = Integer.MAX_VALUE;

    // for(int x: nums){
    //     if(!set.contains(x)){
    //         set.add(x);
    //         minHeap.offer(x);
    //         maxHeap.offer(x);
    //         // max = Math.max(max, x);
    //         // min = Math.min(min, x);
    //     }
    // }