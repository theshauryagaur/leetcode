class Pair{
    int num;
    int min;
    public Pair(int num, int min) {
        this.num = num;
        this.min = min;
    }
}
class MinStack {
    Stack<Pair> st; 
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value, value));
        }
        else st.push(new Pair(value, Math.min(st.peek().min, value)));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().num;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */