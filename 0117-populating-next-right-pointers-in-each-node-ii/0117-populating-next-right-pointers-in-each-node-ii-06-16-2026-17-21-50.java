/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left == null && root.right == null){
            root.next = null;
            return root;
        } 
        Queue<Node> q = new ArrayDeque<>();

        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                Node curr = q.poll();
                if(i < n-1) curr.next = q.peek();
                else curr.next = null;

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }

        return root;
    }
}