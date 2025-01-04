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
    public boolean Symmetry(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left == null && right!=null) || (left!=null && right==null)){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        boolean leftS = Symmetry(left.right, right.left);
        boolean rightS = Symmetry(left.left, right.right);
        return leftS && rightS;
    }
    public boolean isSymmetric(TreeNode root) {
        return Symmetry(root.left, root.right);
    }
}