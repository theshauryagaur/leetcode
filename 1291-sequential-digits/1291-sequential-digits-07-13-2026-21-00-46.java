class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int n1 = (int) Math.log10(low);
        int n2 = (int) Math.log10(high)+1;
        
        List<Integer> ans = new ArrayList<>();

        for(int i=n1; i<=n2; i++){
            int st = 1;
            while(st <= 10-i){
                int num = 0;
                int digi = st+i;
                for(int x = st; x<digi; x++){
                    num = num*10 + x;
                }
                if(num >= low && num <= high) ans.add(num);
                st++;
            }
        }

        return ans;
    }
}