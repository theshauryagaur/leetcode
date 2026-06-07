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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        TreeNode[] node = new TreeNode[100001];
        TreeNode root = new TreeNode();

        for(int[] i : descriptions){
            node[i[1]] = new TreeNode(i[1]);
        }

        for(int[] i : descriptions){

            if(node[i[0]] == null){ // only root node will satisfy this condition
                root = node[i[0]] = new TreeNode(i[0]);
            }

            if(i[2] == 1){
                node[i[0]].left = node[i[1]];
            }
            else node[i[0]].right = node[i[1]];
            
        }
         
        return root;
    }
}