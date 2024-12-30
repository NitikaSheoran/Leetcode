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
    public boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        int rightH = height(root.right);
        int leftH = height(root.left);
        if(Math.abs(rightH - leftH) <= 1 && isBalance(root.right) && isBalance(root.left)){
            return true;
        }
        return false;
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int rightH = 1 + height(root.right);
        int leftH = 1 + height(root.left);
        return Math.max(rightH, leftH);
    }
    public boolean isBalanced(TreeNode root) {
        return isBalance(root);
    }
}