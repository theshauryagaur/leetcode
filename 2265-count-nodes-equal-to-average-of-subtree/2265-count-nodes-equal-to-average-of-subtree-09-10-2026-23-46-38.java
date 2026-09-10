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
    public int[] help(TreeNode root){
        if(root == null) return new int[]{0,0,0};

        if(root.left == null && root.right == null) return new int[]{root.val, 1, 1};

        int nodes = 1;
        int sum = root.val;
        int[] left = help(root.left);
        int[] right = help(root.right);
        int eqNodes = left[2] + right[2];

        nodes += left[1] + right[1];
        sum += left[0] + right[0];
        
        if(root.val == sum/nodes) eqNodes += 1;
        
        return new int[]{sum, nodes, eqNodes};
    }
    public int averageOfSubtree(TreeNode root) {
        return help(root)[2];
    }
}