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
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return isSame(s.right, t.right) && isSame(s.left, t.left);
    }
    public boolean isSub(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }

        if(isSame(root, subRoot)){
            return true;
        }
        

        return isSub(root.left, subRoot) || isSub(root.right, subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSub(root, subRoot);
    }
}