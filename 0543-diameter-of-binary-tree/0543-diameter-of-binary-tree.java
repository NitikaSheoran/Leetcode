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
        if(root == null){
            return 0;
        }
        return Math.max(1+depth(root.left), 1+depth(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int dia = leftDepth + rightDepth;

        return Math.max(dia, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
}