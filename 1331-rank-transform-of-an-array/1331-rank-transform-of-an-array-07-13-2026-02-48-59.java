class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int[] nums = Arrays.copyOf(arr, arr.length);
        Arrays.sort(nums);

        int x = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], x++);
            }
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}