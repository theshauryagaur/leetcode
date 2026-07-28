class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        char mid = 'a';
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<26; i++){
            int x = freq[i];
            char c = (char) ('a'+i);
            if(x%2 != 0) mid = c;
            sb.append((""+c).repeat(x/2));
        }
        String firstHalf = sb.toString();
        String secondHalf = sb.reverse().toString();

        if(n%2 == 0) return firstHalf + secondHalf;
        return  firstHalf + mid + secondHalf;
    }
}