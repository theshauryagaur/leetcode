class Solution {
    public int minAllOneMultiple(int k) {
        HashSet<Integer> set = new HashSet<>();
        if(k == 1) return 1;
        int num = 1;
        set.add(num);
        int ones = 1;
        while(num%k != 0){
            num = (num*10+1) % k;
            ones++;

            if(set.contains(num)) return -1;
            set.add(num);
        }
        return ones;
    }
}