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
    public boolean symm(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(right.val != left.val){
            return false;
        }
        return symm(left.right, right.left) && symm(left.left, right.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return symm(root.left, root.right);
    }
}