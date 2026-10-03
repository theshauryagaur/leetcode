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
    List<Integer> ans;
    TreeNode[] parLeft;
    TreeNode[] parRight;
    TreeNode tar;

    public void build(TreeNode root, TreeNode par, int dir, int tarVal){
        if(root == null) return;
        
        if(root.val == tarVal) tar = root;

        if(dir == 0){
            parLeft[root.val] = par;
        }else{
            parRight[root.val] = par;
        }

        build(root.left, root, 0, tarVal);
        build(root.right, root, 1, tarVal);


    }

    public void dist(TreeNode root, int k, int dir){
        if(root == null) return;
        // 0 -> visit both children
        // 1 -> visit both children
        // 2 -> came from left child, now visit parent and right child
        // 3 -> came from right child, now visit parent and left child
        
        if(k == 0){
            ans.add(root.val);
            return;
        }

        if(dir == 0 || dir == 1){
            dist(root.left, k-1, 0);
            dist(root.right, k-1, 1);
            return;
        }


        if(dir == 2){
            dist(root.right, k-1, 1);
        }
        if(dir == 3){
            dist(root.left, k-1, 0);
        }

        if(parLeft[root.val] != null){
            dist(parLeft[root.val], k-1, 2);
        }
        if(parRight[root.val] != null){
            dist(parRight[root.val], k-1, 3);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        if(k == 0){
            ans.add(target.val);
            return ans;
        }

        tar = null;
        if (root.val == target.val) {
            tar = root;
        }

        parLeft = new TreeNode[501];
        parRight = new TreeNode[501];

        build(root.left, root, 0, target.val);
        build(root.right, root, 1, target.val);

        dist(tar.left, k-1, 0);
        dist(tar.right, k-1, 1);
        
        if(parLeft[tar.val] != null){
            dist(parLeft[tar.val], k-1, 2);
        }
        if(parRight[tar.val] != null){
            dist(parRight[tar.val], k-1, 3);
        }

        return ans;
    }
}