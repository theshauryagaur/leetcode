class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);

        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }

        Arrays.sort(freq, (a,b) -> Integer.compare(b, a));
        //System.out.println(Arrays.toString(freqChar));
        int press = 0;
        int ans = 0;
        int i=0;
        while(i<26 && freq[i] != 0){
            if(i%8 == 0) press++;
            ans += press*freq[i];
            i++;
        }
        return ans;
    }
}