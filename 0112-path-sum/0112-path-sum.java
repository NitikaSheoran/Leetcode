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
    public boolean f(TreeNode root, int target){
        if(root == null) return false;
        if(target-root.val==0 && root.left == null && root.right == null) return true;
        

        return f(root.left, target-root.val) || f(root.right, target-root.val);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return f(root, targetSum);
    }
}