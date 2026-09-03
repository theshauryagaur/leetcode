class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        int n = nums.length;

        Set<Integer> or = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int y: nums){
            Set<Integer> temp = new HashSet<>();

            for(int x : prev) temp.add(y | x);

            temp.add(y);
            or.addAll(temp);
            prev = temp;
        }

        return or.size();
    }
}