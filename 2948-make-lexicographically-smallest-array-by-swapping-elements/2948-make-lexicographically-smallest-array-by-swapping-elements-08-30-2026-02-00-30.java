class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            return a[1]-b[1];
        });

        int[] ans = new int[n];
        int i = 0;
        while(i < n){
            int st = i;
            int end = i;
            PriorityQueue<Integer> q = new PriorityQueue<>();
            q.add(arr[i][1]);
            while(end < n-1 && arr[end+1][0] - arr[end][0] <= limit){
                end++;
                q.add(arr[end][1]);
            }

            while(st <= end){
                ans[q.poll()] = arr[st++][0];
            }

            i = end+1;
        }

        // HashMap<Integer,Integer> freq = new HashMap<>();
        // for(int i: nums){
        //     freq.put(i, freq.getOrDefault(i,0)+1);
        // }
        // int[] ans = new int[n];

        // for(int i=0; i<n; i++){
        //     int x = nums[i];

        //     int ind = Arrays.binarySearch(arr[0], x-limit);
        //     if(ind < 0) ind = -(ind+1);

        //     if(arr[ind][0] == nums[i]){
        //         freq.put(nums[i], freq.get(nums[i])-1);
        //         ans[i] = nums[i];
        //     } 
        //     else{
        //         int y = freq.get(arr[ind][0]);
        //         while(ind < n-1 && y == 0){
        //             ind++;
        //             y = freq.get(arr[ind][0]);
        //         }
        //         if(ind<n){
        //             ans[i] = arr[ind][0];
        //             freq.put(arr[ind][0], freq.get(arr[ind][0])-1);
        //             nums[arr[ind][1]] = x;
        //         }
        //         else{ 
        //             ans[i] = x;
        //             freq.put(x, freq.get(x)-1);
        //         }
        //     }

        // }
        return ans;
    }
}