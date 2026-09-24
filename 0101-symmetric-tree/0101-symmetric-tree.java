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
    public boolean f(TreeNode right, TreeNode left){
        if(right == null && left == null) return true;
        if((right == null && left != null) || (right != null && left == null) || (right.val != left.val)){
            return false;
        }

        return f(right.left, left.right) && f(right.right, left.left); 
    }
    public boolean isSymmetric(TreeNode root) {
        return f(root.right, root.left);
    }
}