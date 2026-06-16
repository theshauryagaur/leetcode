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
    public void helper(Node root){
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        else root.right.next = null;

        if(root.left.left == null) return;

        connect(root.left);
        connect(root.right);
    }
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left == null){
            root.next = null;
            return root;
        }
        helper(root);
        return root;
    }
}