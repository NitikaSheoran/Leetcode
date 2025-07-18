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
    int count = 0;
    int res = -1;
    public void kth(TreeNode root, int k){
        if(root == null){
            return;
        }

        kth(root.left, k);

        count++;
        if(count == k){
            res = root.val;
            return;
        }

        kth(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        kth(root, k);
        return res;
    }
}