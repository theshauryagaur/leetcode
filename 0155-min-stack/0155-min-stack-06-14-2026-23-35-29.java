class MinStack {
    Stack<Long> st; 
    long min ;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    // if the additon of new value causes the min to change that means value < prevMin
    // or (value - prevMin) + value < 0 + value
    // or 2*value - prevMin < value therefore we store newVal = 2*value - prevMin on the stack;
    //and while popping this element if the top element is greater than min than we get the actual value form the formula and this value is stored in min
    public void push(int value) {
        long val = (long) value;
        if(st.isEmpty()){
            st.push(val);
            min = val;
        }
        else{
            if(val < min){
                st.push(2*val - min);
                min = val;
            }
            else st.push(val);
        } 
    }
    
    public void pop() {
        if(st.peek() < min){
            min = (2*min - st.peek());
        }
        st.pop();
    }
    
    public int top() {
        long top = st.peek();

        if(st.peek() < min) return (int) min;
        else return (int) top;
    }
    
    public int getMin() {
        return (int) min;
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