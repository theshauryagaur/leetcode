class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        if(n <= k) return 1;
        int sameSt = 0;
        
        char c = word.charAt(0);
        for(int i=k; i<n; i+=k){
            if(word.charAt(i) == c){
                boolean equal = true;
                int l = 0;

                int j=i;
                for(; j<n; j++){
                    if(word.charAt(j) != word.charAt(l)) {
                        equal = false;
                        break;
                    }
                    l++;
                }

                if(equal){
                    return i/k;
                }
            }
        }

        return (n+k-1)/k;
    }
}