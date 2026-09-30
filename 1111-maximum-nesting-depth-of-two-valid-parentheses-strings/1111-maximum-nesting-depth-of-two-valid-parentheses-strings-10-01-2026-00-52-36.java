class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();

        int[] ans = new int[n];
        int open = 0;
        int close = 0;

        for(int i=0; i<n; i++){
            if(seq.charAt(i) == '('){
                if(open == 0){
                    ans[i] = 0;
                    open = 1;
                }
                else{
                    ans[i] = 1;
                    open = 0;
                }
            }
            else{
                if(close == 0){
                    ans[i] = 0;
                    close = 1;
                }
                else{
                    ans[i] = 1;
                    close = 0;
                }
            }
        }
        return ans;
    }
}