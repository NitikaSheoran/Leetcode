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
    public int goodNode(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val >= max){
            count = 1;
        }
        max = Math.max(root.val, max);
        count += goodNode(root.left, max);
        count += goodNode(root.right, max);
        return count;
    }
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int good = goodNode(root, max);
        return good;
    }
}