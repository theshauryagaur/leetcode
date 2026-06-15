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
    public void helper(TreeNode node, int tar, int curr, List<List<Integer>> ans, List<Integer> list){
        if(node == null){
            return;
        }

        curr += node.val;
        list.add(node.val);

        if(node.left == null && node.right == null){
            if(tar == curr){
                ans.add(new ArrayList<>(list));
            }
        }
        else {
            helper(node.left, tar, curr, ans, list);
            helper(node.right, tar, curr, ans, list);
        }
        
        list.remove(list.size()-1);
        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(root, targetSum, 0, ans, curr);
            
        return ans;
        
        
    }
}