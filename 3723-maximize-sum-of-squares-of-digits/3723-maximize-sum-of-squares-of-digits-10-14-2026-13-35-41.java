class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num*9) return "";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++){
            if(sum == 0){
                sb.append(0);
                continue;
            }
            for(int j=9; j>=0; j--){
                if(sum - j >= 0){
                    sb.append(j);
                    sum -= j;
                    break;
                }
            }
        }

        return sb.toString();
    }
}