/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(TreeNode root, Queue<TreeNode> q){
        if(root == null) return;

        dfs(root.right, q);
        q.offer(root);
        dfs(root.left, q);
    }
    public TreeNode bstToGst(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();

        dfs(root, q);
        int curr = 0;
        while(!q.isEmpty()){
            curr += q.peek().val;
            q.poll().val = curr;
        }

        return root;
    }
}