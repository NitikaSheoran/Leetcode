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
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(1 + depth(root.right), 1 + depth(root.left));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int rightDepth = depth(root.right);
        int leftDepth = depth(root.left);
        if(Math.abs(rightDepth - leftDepth) > 1) return false;
        return isBalanced(root.right) && isBalanced(root.left);
    }
}