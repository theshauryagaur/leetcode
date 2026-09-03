class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        int n = nums.length;

        HashSet<Integer> or = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();

        for(int y: nums){
            HashSet<Integer> temp = new HashSet<>();

            for(int x : prev) temp.add(y | x);

            temp.add(y);
            or.addAll(temp);
            prev = temp;
        }

        return or.size();
    }
}