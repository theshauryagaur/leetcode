class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            char c = senate.charAt(i);
            if(c == 'R') radiant.offer(i);
            else dire.offer(i);
        }

        while(!dire.isEmpty() && !radiant.isEmpty()){
            if(dire.peek() < radiant.peek()){
                dire.offer(dire.poll()+n);
                radiant.poll();
            }
            else{
                radiant.offer(radiant.poll()+n);
                dire.poll();
            }
        }
        return dire.size() == 0 ? "Radiant" : "Dire";
    }
}