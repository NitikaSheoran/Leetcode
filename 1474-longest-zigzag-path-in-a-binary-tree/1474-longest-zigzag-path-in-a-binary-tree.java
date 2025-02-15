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
    int pathLength=0;
    public void dfs(TreeNode root, int steps, boolean left){
        if(root==null){
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if(left){
            dfs(root.left, steps+1, false);
            dfs(root.right, 1, true);
        }else{
            dfs(root.left, 1, false);
            dfs(root.right, steps+1, true);
        }
    }
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, true);
        return pathLength;

    }
}