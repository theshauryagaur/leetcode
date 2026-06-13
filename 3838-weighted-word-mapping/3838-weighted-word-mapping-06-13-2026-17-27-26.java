class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String s: words){
            int x = 0;
            for(int i=0; i<s.length(); i++){
                x += weights[s.charAt(i)-'a'];
            }

            x = x%26;

            sb.append((char) (26- x + 'a' - 1) );
        }
        return sb.toString();
    }

}