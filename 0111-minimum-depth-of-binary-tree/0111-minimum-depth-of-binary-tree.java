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
    public int minDepth1(TreeNode root){
        if(root == null) return 0;
        int l = minDepth1(root.left);
        int r = minDepth1(root.right);
        if(l==0 || r==0){
            return Math.max(l,r)+1;
        }
        return Math.min(l,r)+1;
    }
    public int minDepth(TreeNode root) {
        return minDepth1(root);
    }
}