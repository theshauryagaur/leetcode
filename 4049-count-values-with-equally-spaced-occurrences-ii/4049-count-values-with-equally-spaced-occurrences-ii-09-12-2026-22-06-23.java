class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,List<Integer>> ind = new HashMap<>();
        for(int i=0; i<n; i++){
            int x = nums[i];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            
            if(!ind.containsKey(x)){
                ind.put(x, new ArrayList<>());
            }
            ind.get(x).add(i);
        }

        for(List<Integer> temp: ind.values()){
            int sz = temp.size();
            if(sz < 3) continue;

            int prev = temp.get(1);
            int gap = prev - temp.get(0);
            boolean possi = true;

            for(int j=2; j<sz; j++){
                int curr = temp.get(j);
                if(curr - prev != gap){
                    possi = false;
                    break;
                }

                prev = curr;
            }

            if(possi) ans++;
        }
        return ans;
    }
}