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
    public int sum(TreeNode node, int num){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null) {
            num = num*10 + node.val;
            return num;
        }
        num = num*10 + node.val;
        return sum(node.left, num) + sum(node.right, num);
    }
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        return sum(root, 0);
    }
}