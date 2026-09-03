class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        int n = nums.length;

        HashSet<Integer> or = new HashSet<>();

        HashSet<Integer> prev = new HashSet<>();

        for(int i=0; i<n; i++){
            // Iterator<Integer> it = or.iterator();

            // while(it.hasNext()){
            //     Integer x = it.next();
            //     temp.add(nums[i] | x);
            // }
            HashSet<Integer> temp = new HashSet<>();

            for(int x : prev) temp.add(nums[i] | x);

            temp.add(nums[i]);
            or.addAll(temp);
            prev = temp;
        }

        return or.size();
    }
}