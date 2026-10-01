class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.add(c);
            }
            else{
                if(st.isEmpty()) return false;
                if(c == ')' && st.peek() == '(') st.pop();
                else if(c == ']' && st.peek() == '[') st.pop();
                else if(c == '}' && st.peek() == '{') st.pop();
                else return false;
            }
        }
        System.out.println("hi");
        return st.isEmpty() ? true : false;
    }
}