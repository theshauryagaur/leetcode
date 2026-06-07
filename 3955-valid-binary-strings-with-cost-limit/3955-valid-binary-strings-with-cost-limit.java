class Solution {
    public void help(int n, String curr, List<String> ans, int k, int cost){
        int len = curr.length();
        
        if(k < cost) return;
        if(len >= 2){
            if(curr.charAt(len-1) == '1'){
                if(curr.charAt(len-2) == '1'){
                    return;
                }
            }
        }
        
        if(len == n){
            ans.add(curr);
            return;
        }

        help(n, curr+"0", ans, k, cost);
        help(n, curr+"1", ans, k, cost+len);
        
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        help(n, "", ans, k, 0);
        
        return ans;
    }
}