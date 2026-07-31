class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }

        Integer[] freqChar = new Integer[26];
        for(int i=0; i<26; i++) freqChar[i]=i;

        Arrays.sort(freqChar, (a,b) -> Integer.compare(freq[b], freq[a]));
        //System.out.println(Arrays.toString(freqChar));
        int press = 0;
        int ans = 0;
        int i=0;
        while(i<26 && freq[freqChar[i]] != 0){
            if(i%8 == 0) press++;
            ans += press*freq[freqChar[i]];
            i++;
        }
        return ans;
    }
}