class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        int n = nums.length;

        HashSet<Integer> or = new HashSet<>();

        HashSet<Integer> prev = new HashSet<>();
        prev.add(nums[0]);
        or.add(nums[0]);
        
        for(int i=1; i<n; i++){
            // Iterator<Integer> it = or.iterator();

            // while(it.hasNext()){
            //     Integer x = it.next();
            //     temp.add(nums[i] | x);
            // }
            HashSet<Integer> temp = new HashSet<>();

            for(int x : prev) temp.add(nums[i] | x);

            or.addAll(temp);
            prev = temp;
            prev.add(nums[i]);
            or.add(nums[i]);
        }

        return or.size();
    }
}