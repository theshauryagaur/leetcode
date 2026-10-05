class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') st.add(i);
            else{
                int curr = 0;
                if(st.peek() >= 0){
                    st.pop();
                    st.add(-1);
                }
                else {
                    while(st.peek() < 0){
                        curr += st.pop();
                    }
                    st.pop();
                    st.add(2*curr);
                }

            }
        }
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return -ans;
    }
}