/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val >= p.val && root.val <= q.val) return root;
        
        if(root.val >= p.val && root.val >= q.val) return lca(root.left, p, q);

        return lca(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val) return lca(root,p,q);
        return lca(root, q, p);
    }
}