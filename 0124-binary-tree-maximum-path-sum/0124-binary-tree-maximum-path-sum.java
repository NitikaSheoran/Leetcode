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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, maxPathSum2(root.left));
        int right = Math.max(0, maxPathSum2(root.right));
        
        int curr = root.val + left + right;
        maxSum = Math.max(maxSum, curr);
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return maxSum;
    }
}