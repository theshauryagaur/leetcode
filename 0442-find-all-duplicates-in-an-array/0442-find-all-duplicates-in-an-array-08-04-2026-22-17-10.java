class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int i: nums){
            if(set.contains(i)) ans.add(i);
            else set.add(i);
        }
        return ans;
    }
}