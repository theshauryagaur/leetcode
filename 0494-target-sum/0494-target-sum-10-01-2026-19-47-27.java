class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> ways = new HashMap<>();
        ways.put(0,1);

        for(int x: nums){
            Map<Integer, Integer> next = new HashMap<>();
            for(int k: ways.keySet()){
                int occur = ways.get(k);
                next.put(k+x, next.getOrDefault(k+x, 0) + occur);
                next.put(k-x, next.getOrDefault(k-x, 0) + occur);
            }
            ways = next;
        }

        if(!ways.containsKey(target)) return 0;
        return ways.get(target);
    }
}