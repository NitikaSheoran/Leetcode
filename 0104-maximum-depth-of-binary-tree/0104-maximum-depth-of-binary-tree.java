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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = 1 + height(root.left);
        int rightH = 1 + height(root.right);
        return Math.max(leftH, rightH);
    }
    public int maxDepth(TreeNode root) {
        int h = height(root);
        return h;
    }
}