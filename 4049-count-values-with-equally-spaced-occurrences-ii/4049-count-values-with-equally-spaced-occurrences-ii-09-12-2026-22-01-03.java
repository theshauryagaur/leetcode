class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,List<Integer>> ind = new HashMap<>();
        for(int i=0; i<n; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            
            if(!ind.containsKey(nums[i])){
                ind.put(nums[i], new ArrayList<>());
            }
            ind.get(nums[i]).add(i);
        }

        for(int num: ind.keySet()){
            int x = freq.get(num);
            if(x < 3) continue;

            List<Integer> temp = ind.get(num);
            int gap = temp.get(1) - temp.get(0);
            boolean possi = true;

            for(int j=2; j<temp.size(); j++){
                if(temp.get(j) - temp.get(j-1) != gap) possi = false;
            }

            if(possi) ans++;
        }
        return ans;
    }
}