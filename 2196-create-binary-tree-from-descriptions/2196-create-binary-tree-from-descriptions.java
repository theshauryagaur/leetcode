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
        
        TreeNode[] set = new TreeNode[100001];
        int[] children = new int[100001];
        TreeNode root = new TreeNode();

        for(int[] i : descriptions){
            TreeNode node ;
            TreeNode child ;

            if( set[i[0]] == null ){
                node = new TreeNode(i[0]);
                if(children[i[0]] != 1) children[i[0]] = -1;
            }
            else node = set[i[0]];

            if( set[i[1]] == null ){
                child = new TreeNode(i[1]);
            }
            else child = set[i[1]];

            children[i[1]] = 1;

            if(i[2] == 1){
                node.left = child;
            }
            else node.right = child;

            set[i[0]] = node;
            set[i[1]] = child;

        }

        for(int i=1; i<=100000; i++){
            if(children[i] == -1){
                root = set[i];
                break;
            }
        }
        return root;
    }
}