class NumArray {
    int n;
    int[] tree;
    int[] nums;
    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;
        tree = new int[4*n];

        build(0, n-1, 0);
        
    }

    public void build(int l, int r, int i){
        if(l == r){
            tree[i] = nums[l];
            return;
        }
        int mid = l + (r - l)/2;

        build(l, mid, 2*i + 1);
        build(mid + 1, r, 2*i + 2);

        tree[i] = tree[2*i + 1] + tree[2*i + 2];
    }
    
    public void update(int index, int val) {
        updateNode(0, 0, n-1, index, val);
    }
    
    public void updateNode(int node, int st, int end, int ind, int val){
        if(ind < st || end < ind) return;
        if(st == end){
            tree[node] = val;
            return;
        }

        int mid = (st + end)/2;

        int leftNode = 2*node + 1, rightNode = 2*node + 2;

        if(ind <= mid) updateNode(leftNode, st, mid, ind, val);
        else  updateNode(rightNode, mid + 1, end, ind, val);

        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public int query(int node, int st, int end, int L, int R){
        if(R < st || L > end) return 0;

        if(L <= st && R >= end) return tree[node];

        int mid = (end+st)/2;

        int leftNode = 2*node + 1, rightNode = 2*node + 2;

        return query(leftNode, st, mid, L, R) + query(rightNode, mid + 1, end, L , R);
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */