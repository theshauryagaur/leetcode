class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        one.add(nums[0]);
        two.add(nums[1]);

        int len1 = 1;
        int len2 = 1;
        for(int i=2; i<n; i++){
            if(one.get(len1-1) > two.get(len2-1)){
                len1++;
                one.add(nums[i]);
            }
            else{
                len2++;
                two.add(nums[i]);
            }
        }
        int i=0;
        for(int j=0; j<len1; j++){
            nums[i] = one.get(j);
            i++;
        }
        for(int j=0; j<len2; j++){
            nums[i] = two.get(j);
            i++;
        }
        return nums;
    }
}