class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(nums[i] < min) min = nums[i];
        }

        return sum - min * n;
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