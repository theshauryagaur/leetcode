class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int n = pattern.length();

        int[] patt = new int[26];
        for(int i=0; i<n; i++) patt[i] = pattern.charAt(i)-'a';
        
        for(String s: words){
            int[] map = new int[26];
            int[] mapped = new int[26];

            boolean canbe = true;

            for(int i=0; i<n; i++){
                int ch = patt[i];

                if(map[ch] == 0){
                    int wordChar = s.charAt(i)-'a';
                    if(mapped[wordChar] == 0){
                        mapped[wordChar] = 1;
                        map[ch] = wordChar+1;
                    } 
                    else{
                        canbe = false;
                        break;
                    }
                }
                else {
                    if(map[ch]-1 != s.charAt(i)-'a'){
                        canbe = false;
                        break;
                    } 
                }
            }
            if(canbe) ans.add(s);
        }
        return ans;
    }
}