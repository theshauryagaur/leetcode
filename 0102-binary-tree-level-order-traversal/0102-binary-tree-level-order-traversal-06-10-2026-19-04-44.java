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
    private void level(TreeNode root,List<List<Integer>> list, int height) {
        if(root == null) return;
        if(list.size() > height){
            List<Integer> l = list.get(height);
            l.add(root.val);
        } 
        else{
            list.add(new ArrayList<>());
            list.get(height).add(root.val);
        }   
        level(root.left, list, 1+height);
        level(root.right, list, 1+height);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        level(root, list, 0);
        return list;
    }
}