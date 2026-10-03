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
    List<TreeNode> list;
    public void preorder(TreeNode root){
        if(root == null) return;

        list.add(root);
        preorder(root.left);
        preorder(root.right);
        return;
    }
    public void flatten(TreeNode root) {
        if(root == null) return;

        list = new ArrayList<>();
        preorder(root);

        TreeNode curr = root;
        for(int i=1; i<list.size(); i++){
            curr.right = list.get(i);
            curr.left = null;
            curr = curr.right;
        }

    }
}