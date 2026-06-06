class Solution {
    public int help(int a, int b, int n){
        return n-b;
    }
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] a = new int[n];
        int indA = -1;
        int[] b = new int[n];
        int indB = -1;
        int[] c = new int[n];
        int indC = -1;

        for(int i = n-1; i>=0; i--){
            char x = s.charAt(i);
            if(x == 'a'){
                indA = i;
            }
            else if(x == 'b'){ 
                indB = i;
            }
            else if(x == 'c') {
                indC = i;
            }

            a[i] = indA;
            b[i] = indB;
            c[i] = indC;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            indA = a[i]; indB = b[i]; indC = c[i];
            
            if(indA == -1 || indB==-1 || indC == -1) break;
            if(s.charAt(i) == 'a'){
                ans += help(a[i], Math.max(b[i],c[i]), n);
            }
            else if(s.charAt(i) == 'b'){
                ans += help(b[i], Math.max(a[i],c[i]), n);
            }
            else if(s.charAt(i) == 'c'){
                ans += help(c[i], Math.max(b[i],a[i]), n);
            }
        }
        return ans;
    }
}