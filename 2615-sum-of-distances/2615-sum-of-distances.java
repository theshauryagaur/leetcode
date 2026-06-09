class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        long[] prefix = new long[n]; //stores the summation of indices having same value in the original array including i

        for(int i=0; i<n; i++){
            ArrayList<Integer> x = map.computeIfAbsent(nums[i], k-> new ArrayList<>());
            x.add(i);

            int size = x.size();
            if(size > 1){
                prefix[i] = prefix[x.get(size-2)] + i;
            }
            else {
                prefix[i] = i;
            }
        }

        long[] ans = new long[n];
        for(int num: map.keySet()){
            ArrayList<Integer> x = map.get(num);
            int sz = x.size();

            long total = prefix[x.get(sz-1)];
                
            if(sz == 1) ans[x.get(sz-1)] = 0;
            else{
                for(int i=0; i < sz; i++){
                    int ind = x.get(i);

                    ans[ind] = total - (long)ind*(sz-2*i-2) - 2*prefix[ind];
                    //((total - prefix[ind]) - (sz-i-1)*ind)     +    i*ind - (prefix[ind]-ind);
                    //          right rum                                      left sum

                }
            }
        }

        return ans;
    }
}