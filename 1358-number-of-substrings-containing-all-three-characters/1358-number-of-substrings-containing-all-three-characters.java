class Solution {
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
                ans += n - Math.max(b[i],c[i]);
            }
            else if(s.charAt(i) == 'b'){
                ans += n - Math.max(a[i],c[i]);
            }
            else if(s.charAt(i) == 'c'){
                ans += n - Math.max(b[i],a[i]);
            }
        }
        return ans;
    }
}