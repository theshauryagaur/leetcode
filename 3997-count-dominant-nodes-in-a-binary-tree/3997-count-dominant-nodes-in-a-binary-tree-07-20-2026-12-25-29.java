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
    public int[] helper(TreeNode root){
        if(root == null) return new int[]{-1, 0};
        if(root.left == null && root.right == null) return new int[]{root.val,1};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int max = Math.max(root.val, Math.max(left[0], right[0]));
        return new int[]{max , (root.val == max ? 1 : 0) + left[1]+right[1]};
    }
    public int countDominantNodes(TreeNode root) {
        return helper(root)[1];
    }
}