class FrontMiddleBackQueue {
    LinkedList<Integer> front;
    LinkedList<Integer> mid;
    LinkedList<Integer> last;
    int sz = 0;
    public FrontMiddleBackQueue() {
        front = new LinkedList<Integer>();
        mid = new LinkedList<Integer>();
        last = new LinkedList<Integer>();
        sz = 0;
    }
    
    public void pushFront(int val) {
        if(sz <= 1){
            mid.addFirst(val);
            sz++;
        }
        else if(sz % 2 == 0){
            front.addFirst(val);
            last.addFirst(mid.removeLast());
            sz++;
        }
        else{
            front.addFirst(val);
            mid.addFirst(front.removeLast());
            sz++;
        }
    }
    
    public void pushMiddle(int val) {
        if(sz <= 1){
            mid.addFirst(val);
            sz++;
        }
        else if(sz % 2 == 0){
            front.addLast(mid.removeFirst());
            last.addFirst(mid.removeLast());
            mid.add(val);
            sz++;
        }
        else{
            mid.addFirst(val);
            sz++;
        }
    }
    
    public void pushBack(int val) {
        if(sz <= 1){
            mid.add(val);
            sz++;
        }
        else if(sz % 2 == 0){
            last.add(val);
            front.add(mid.removeFirst());
            sz++;
        }
        else{
            last.add(val);
            mid.addLast(last.removeFirst());
            sz++;
        }
    }
    
    public int popFront() {
        if(sz == 0) return -1;
        else if(sz <= 2){
            sz--;
            return mid.removeFirst();
        }
        else{
            if(sz % 2 == 0){
                front.addLast(mid.removeFirst());
                sz--;
                return front.removeFirst();
            }
            else{
                mid.add(last.removeFirst());
                sz--;
                return front.removeFirst();
            }
        }
        
    }
    
    public int popMiddle() {
        if(sz == 0) return -1;
        else if(sz <= 2){
            sz--;
            return mid.removeFirst();
        }
        else{
            if(sz % 2 == 0){
                sz--;
                return mid.removeFirst();
            }
            else{
                int x = mid.removeFirst();
                mid.add(front.removeLast());
                mid.add(last.removeFirst());
                sz--;
                return x;
            }
        }
        
    }
    
    public int popBack() {
        if(sz == 0) return -1;
        else if(sz <= 2){
            sz--;
            return mid.removeLast();
        }
        else{
            if(sz % 2 == 0){
                last.addFirst(mid.removeLast());
                sz--;
                return last.removeLast();
            }
            else{
                mid.addFirst(front.removeLast());
                sz--;
                return last.removeLast();
            }
        }
        
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */