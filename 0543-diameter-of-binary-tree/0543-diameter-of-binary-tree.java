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
    int  dia = 0;
    public int depth(TreeNode root){
        if(root == null) return 0;
        int right = depth(root.right);
        int left = depth(root.left);
        dia = Math.max(right+left, dia);
        return 1 + Math.max(right, left);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return dia;
    }
}